package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.data.connection.JdbcService;
import com.project.spring.SpringConfig;

public class Start7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcService jdbcService = context.getBean("jdbcService", JdbcService.class);
        jdbcService.createTable("OneMoreTest");
    }
}
