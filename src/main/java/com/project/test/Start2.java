package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.hibernate.ActionPairNameDatabase;
import com.project.spring.SpringConfig;

public class Start2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ActionPairNameDatabase assetTransaction = context.getBean("actionPairNameDatabase", ActionPairNameDatabase.class);
        assetTransaction.deleteAsset("BTCUSDT");
    }
}
