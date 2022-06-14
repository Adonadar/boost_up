package com.project.test;

import com.project.data.connection.JdbcService;
import com.project.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start30 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcService jdbcService = context.getBean("jdbcService", JdbcService.class);
        boolean is = jdbcService.isDatabaseExist("boost_up_db");
        System.out.println(is);
    }
}
