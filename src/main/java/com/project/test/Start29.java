package com.project.test;

import com.project.service.ServicePreparation;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start29 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ServicePreparation prepareToWork = context.getBean("prepareToWork", ServicePreparation.class);
//        prepareToWork.makePreparation();
    }
}
