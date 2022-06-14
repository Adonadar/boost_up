package com.project.data.download;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticData {
    public static String NAME_OF_DATABASE = null;

    public StaticData(@Value("${create.database.name}") String name) {
        this.NAME_OF_DATABASE = name;
    }
}
