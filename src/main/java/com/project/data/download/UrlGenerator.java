package com.project.data.download;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class UrlGenerator {

    private String url = "https://data.binance.vision/data/spot/monthly/klines/";

    private String pathToSaveFile = "C:\\test\\";

    private String pathToDemoFile = "c:/test/";

    public String getPathToDemoFile() {
        return pathToDemoFile;
    }

    @Value("${url.fileFormat}")
    private String fileFormat;

    public String getPathToSaveFile() {
        return pathToSaveFile;
    }

    private String pareOfAsset;

    private String period;

    @Value("${url.startDateYear}")
    private int dateYear;

    @Value("${url.startDateMonth}")
    private int dateMonth;

    public int getDateYear() {
        return dateYear;
    }

    public void setDateYear(int dateYear) {
        this.dateYear = dateYear;
    }

    public int getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(int dateMonth) {
        this.dateMonth = dateMonth;
    }

    public String getPareOfAsset() {
        return pareOfAsset;
    }

    public void setPareOfAsset(String pareOfAsset) {
        this.pareOfAsset = pareOfAsset;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUrl() {
        return url;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public URL getConnection() {
        try {
            return new URL(
                (url +
                pareOfAsset + "/" +
                period + "/" +
                pareOfAsset + "-" +
                period + "-" +
                dateYear + "-" +
                getMonthString() +
                fileFormat));

        } catch (MalformedURLException e) {
            System.out.println("ошибка создания url");
            e.toString();
            return null;
        }
    }

    public String getMonthString() {
        String dateMonthString;

        if(getDateMonth()<10) {
            dateMonthString = "0" + getDateMonth();
        } else {
            dateMonthString = String.valueOf(getDateMonth());
        }

        return dateMonthString;
    }

    public String getNameForSaveFileZip() {
        String path = pareOfAsset + "-" +
        period + "-" +
        dateYear + "-" +
        getMonthString() +
        fileFormat;

        return path;
    }

    public String getNameForSaveFileCsv() {
        String path = pareOfAsset + "-" +
        period + "-" +
        dateYear + "-" +
        getMonthString() +
        ".csv";
        return path;
    }

    public String getToLoadFile() {
        return "\"" + getPathToSaveFile() + getNameForSaveFileCsv() + "\"";
    }
}
