package com.project.test;

import com.project.spring.SpringConfig;
import com.webcerebrium.binance.api.BinanceApiException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start16 {
    public static void main(String[] args) throws BinanceApiException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
