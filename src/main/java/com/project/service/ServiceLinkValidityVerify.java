package com.project.service;

import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ServiceLinkValidityVerify {
    private int responceCode = 0;

    public boolean verify(String httpLink) {
        try {
            URL url = new URL(httpLink);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            responceCode = huc.getResponseCode();
        } catch (Exception ex) {
            System.out.println("Ошибка при проверке ссылки на валидность");
        }

        if (responceCode == 200) {
            return true;
        }

        return false;
    }
}
