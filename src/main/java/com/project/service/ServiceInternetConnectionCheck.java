package com.project.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Component
public class ServiceInternetConnectionCheck {
    private String mainPage = "https://www.binance.com/en";

    public boolean check() {
        try {
            URL url = new URL(mainPage);
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (MalformedURLException e) {
            System.out.println("Нет соединения с интернетом");
            return false;
        } catch (IOException e) {
            System.out.println("Нет соединения с интернетом");
            return false;
        }
    }
}
