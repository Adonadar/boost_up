package com.project.data.download;

import com.project.constant.Constant;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class UrlGenerator {

    private String url;

    private String pathToDirectory;

    private String pareOfAsset;

    private String period;

    private int dateYear;

    private int dateMonth;

    public URL getConnection() {
        try {
            return new URL(
                (url +
                pareOfAsset + "/" +
                period + "/" +
                pareOfAsset + "-" +
                period + "-" +
                dateYear + "-" +
                getMonthLikeString() +
                ".zip"));

        } catch (MalformedURLException e) {
            System.out.println("ошибка создания url");
            e.toString();
            return null;
        }
    }

    private String getMonthLikeString() {
        String dateMonthString;

        if(getDateMonth()<10) {
            dateMonthString = "0" + getDateMonth();
        } else {
            dateMonthString = String.valueOf(getDateMonth());
        }

        return dateMonthString;
    }

    public String getNameToFile(String format) {
        String path;
        path = pareOfAsset + "-" +
                period + "-" +
                dateYear + "-" +
                getMonthLikeString();

        switch (format) {
            case "zip" :
                path = path + ".zip";
                break;
            case "csv" :
                path = path + ".csv";
                break;
            default: System.out.println("illegal format");
        }

        return path;
    }

    public UrlGenerator() {
        url = Constant.URL_TO_BINANCE_DATA;
        pathToDirectory = Constant.PATH_TO_DIRECTORY;
        dateYear = Constant.DATE_YEAR;
        dateMonth = Constant.DATE_MONTH;
    }

    public String getPathToDirectory() {
        return pathToDirectory;
    }

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
}
