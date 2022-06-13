package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.algorithms.OldAlgorithmGreyMouse;
import com.project.spring.SpringConfig;

public class Start14 {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OldAlgorithmGreyMouse greyMouse = context.getBean("greyMouse", OldAlgorithmGreyMouse.class);

        greyMouse.analysis();

        context.close();
    }
}
