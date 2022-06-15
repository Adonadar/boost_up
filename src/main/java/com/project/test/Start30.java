package com.project.test;

import com.project.constant.Constant;
import com.project.service.ServiceCreateDirectory;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start30 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ServiceCreateDirectory serviceCreateDirectory = context.getBean("serviceCreateDirectory", ServiceCreateDirectory.class);
        serviceCreateDirectory.create(Constant.PATH_TO_DIRECTORY);
    }
}
