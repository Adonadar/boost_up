package com.project.service;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ServiceCreateDirectory {
    public void create(String path) {
        String[] array = path.split("/");
        String pathTemporary = array[0];
        for(int i = 1; i < array.length; i++) {
            pathTemporary = pathTemporary + "/" + array[i];
            File file = new File(pathTemporary);
            if(!file.isDirectory()) {
                file.mkdir();
            }
        }
    }
}
