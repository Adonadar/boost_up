package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.hibernate.ActionPairNameDatabase;
import com.project.data.download.DataLoader;
import com.project.spring.SpringConfig;

public class MainStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataLoader dataLoader = context.getBean("dataLoader", DataLoader.class);
        ActionPairNameDatabase actionPairNameDatabase = context.getBean("actionPairNameDatabase", ActionPairNameDatabase.class);

        actionPairNameDatabase.addAsset("BNBUSDT", "1m");

        dataLoader.download();

        context.close();
    }
}
