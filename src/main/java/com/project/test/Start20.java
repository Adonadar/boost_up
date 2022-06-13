package com.project.test;

import com.project.algorithms.OldAlgorithmGreyMouse;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start20 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OldAlgorithmGreyMouse greyMouse = context.getBean("greyMouse",  OldAlgorithmGreyMouse.class);

        greyMouse.analysis();
        greyMouse.showBalance();

        context.close();
    }
}
