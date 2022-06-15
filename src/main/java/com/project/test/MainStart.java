package com.project.test;

import com.project.service.ServicePreparation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.hibernate.ActionPairNameDatabase;
import com.project.data.download.DataLoader;
import com.project.spring.SpringConfig;

public class MainStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataLoader dataLoader = context.getBean("dataLoader", DataLoader.class);
        ServicePreparation preparation = context.getBean("servicePreparation", ServicePreparation.class);
        ActionPairNameDatabase actionPairNameDatabase = context.getBean("actionPairNameDatabase", ActionPairNameDatabase.class);

        preparation.start();

        actionPairNameDatabase.addAsset("BTCUSDT", "1m");

        dataLoader.download();

        context.close();
    }
}
