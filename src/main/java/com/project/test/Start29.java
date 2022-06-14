package com.project.test;

import com.project.data.download.PrepareToWork;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start29 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        PrepareToWork prepareToWork = context.getBean("prepareToWork", PrepareToWork.class);
        prepareToWork.makePreparation();
    }
}
