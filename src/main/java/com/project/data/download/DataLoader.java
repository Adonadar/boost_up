package com.project.data.download;

import com.project.service.ServiceLinkValidityVerify;
import com.project.service.ServiceInternetConnectionCheck;
import com.project.data.connection.JdbcService;
import com.project.data.hibernate.ActionPairNameDatabase;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.data.hibernate.entity.GeneralTable;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Component
public class DataLoader {
    private boolean isDeleteFile = true;

    private Calendar calendar;

    private ServiceInternetConnectionCheck internetConnectionCheck;

    private UrlGenerator urlGenerator;

    private ActionPairNameDatabase actionPairNameDatabase;

    private ServiceLinkValidityVerify linkValidityVerify;

    private JdbcService jdbcService;

    private UpdateData updateData;

//    @Value("${url.startDateYear}")
    private int dateYear = 2021;

//    @Value("${url.startDateMonth}")
    private int dateMonth = 1;

    @Autowired
    public void setLinkValidityVerify(ServiceLinkValidityVerify linkValidityVerify) {
        this.linkValidityVerify = linkValidityVerify;
    }

    @Autowired
    public void setUrlGenerator(UrlGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
    }

    @Autowired
    public void setActionPairNameDatabase(ActionPairNameDatabase actionPairNameDatabase) {
        this.actionPairNameDatabase = actionPairNameDatabase;
    }

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Autowired
    public void setInternetConnectionCheck(ServiceInternetConnectionCheck internetConnectionCheck) {
        this.internetConnectionCheck = internetConnectionCheck;
    }

    @Autowired
    public void setUpdateData(UpdateData updateData) {
        this.updateData = updateData;
    }

    public void download() {
        if(!internetConnectionCheck.check()) {
            return;
        }

        List<GeneralTable> generalTableList = actionPairNameDatabase.getAllAsset();

        calendar = Calendar.getInstance();

        for (GeneralTable generalTable: generalTableList) {
            String asset = generalTable.getAsset();
            String period = generalTable.getPeriod();
            String nameOfTable = generalTable.getNameOfTable();

            if (jdbcService.isTableExist(nameOfTable)) {
                continue;
            }

            urlGenerator.setPareOfAsset(asset);
            urlGenerator.setPeriod(period);

            jdbcService.createTable(generalTable.getNameOfTable());

            for (int year = urlGenerator.getDateYear(); year <= calendar.get(Calendar.YEAR); year++) {
                for (int month = urlGenerator.getDateMonth(); month <= 12; month++) {
                    if(urlGenerator.getDateYear() == calendar.get(Calendar.YEAR)
                            && urlGenerator.getDateMonth() == calendar.get(Calendar.MONTH) + 1) {
                        break;
                    }

                    if (!linkValidityVerify.verify(urlGenerator.getConnection().toString())) {
                        System.out.println("[Нет ответа по запросу " +
                                urlGenerator.getPareOfAsset() + "-" + urlGenerator.getPeriod() +
                                " дата: " + urlGenerator.getDateYear() + "-" + urlGenerator.getDateMonth() +
                                " ожидается генерация нового запроса]");
                        urlGenerator.setDateMonth(urlGenerator.getDateMonth() + 1);
                        continue;
                    }

                    System.out.println("[Установлено соединение с сервером по запросу " +
                            urlGenerator.getPareOfAsset() + "-" + urlGenerator.getPeriod() +
                            " дата: " + urlGenerator.getDateYear() + "-" + urlGenerator.getDateMonth() +
                            " скачивание]");

                    try {
                        FileUtils.copyURLToFile(
                                urlGenerator.getConnection(),
                                new File(urlGenerator.getPathToSaveFile() + urlGenerator.getNameForSaveFileZip()), 10000, 10000);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("[Файл сохранен]");

                    try {
                        new ZipFile(urlGenerator.getPathToSaveFile() + urlGenerator.getNameForSaveFileZip())
                                .extractAll(urlGenerator.getPathToSaveFile());
                    } catch (ZipException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("[Файл разархивирован]");

                    jdbcService.loadData(nameOfTable, (urlGenerator.getPathToDemoFile() + urlGenerator.getNameForSaveFileCsv()));

                    System.out.println("[Выгрузка данных в базу данных успешна]");

                    if (isDeleteFile) {
                        FileUtils.deleteQuietly(new File(urlGenerator.getPathToSaveFile() +
                                urlGenerator.getNameForSaveFileZip()));
                        FileUtils.deleteQuietly(new File(urlGenerator.getPathToSaveFile() +
                                urlGenerator.getNameForSaveFileCsv()));
                    }

                    System.out.println("[Удаление файлов]");

                    urlGenerator.setDateMonth(urlGenerator.getDateMonth() + 1);

                    System.out.println("[Цикл успешно завершен]");
                }
                urlGenerator.setDateMonth(1);
                urlGenerator.setDateYear(urlGenerator.getDateYear() + 1);
            }
//            updateData.update(generalTable.getNameOfTable());
            urlGenerator.setDateMonth(dateMonth);
            urlGenerator.setDateYear(dateYear);
        }
    }
}