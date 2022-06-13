package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.download.DataLoader;
import com.project.spring.SpringConfig;

public class Start4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataLoader dataLoader = context.getBean("dataLoader", DataLoader.class);

        dataLoader.download();

        context.close();
    }
}
