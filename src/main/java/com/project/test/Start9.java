package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.service.ServiceLinkValidityVerify;
import com.project.spring.SpringConfig;


public class Start9 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ServiceLinkValidityVerify linkValidityVerify = context.getBean("linkValidityVerify", ServiceLinkValidityVerify.class);
        System.out.println(linkValidityVerify.verify("https://data.binance.vision/data/spot/monthly/klines/BTCUSDT/1m/BTCUSDT-1m-2018-04.zip"));
    }
}
