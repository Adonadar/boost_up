package com.project.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Start5 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://data.binance.vision/data/spot/monthly/klines/BTCUSDT/1m/BTCUSDT-1m-2018-01.zip");
        FileUtils.copyURLToFile(url,
                new File("C:\\test\\test.zip"), 10000, 1000);
    }
}
