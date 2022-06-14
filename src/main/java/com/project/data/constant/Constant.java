package com.project.data.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static String NAME_OF_DATABASE = null;

    public Constant(@Value("${create.database.name}") String name) {
        this.NAME_OF_DATABASE = name;
    }
}
