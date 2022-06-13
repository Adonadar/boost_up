package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.project.spring.SpringConfig;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Path path = Paths.get("C:\\test\\LTCUSDT-1m-2019-01.zip");
        System.out.println(Files.exists(path));
    }
}
