package com.project.test;

import net.lingala.zip4j.exception.ZipException;

public class Start3 {
    public static void main(String[] args) throws ZipException {
//        new ZipFile("C:\\test\\2018-05.zip").extractAll("C:\\test");
        String sql = "LOAD DATA INFILE " + "\""
                + "c:/test/"
                + "BTCUSDT-1m-2018-10.csv" + "\"" +
                "INTO TABLE my_db.testup FIELDS TERMINATED BY ',' (openTime, openKline, hightPrice, \n" +
                "lowPrice, closeKline, volume, closeTime, quoteAssetVolume, numberOfTrades, \n" +
                "takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume, ignoreCV);  ";
        System.out.println(sql);
    }
}