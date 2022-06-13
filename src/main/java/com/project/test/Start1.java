package com.project.test;

import com.project.algorithms.Head;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Start1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Head head = context.getBean("head", Head.class);

        head.start();

        context.close();
    }
}
