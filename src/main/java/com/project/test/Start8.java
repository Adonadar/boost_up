package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.hibernate.ActionPairNameDatabase;
import com.project.spring.SpringConfig;

public class Start8 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ActionPairNameDatabase action = context.getBean("actionPairNameDatabase", ActionPairNameDatabase.class);
        action.addAsset("BTCUSDT", "1m");
    }
}
