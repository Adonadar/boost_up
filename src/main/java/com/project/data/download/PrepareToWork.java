package com.project.data.download;

import com.project.data.connection.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrepareToWork {
    @Value("${create.database.name}")
    private String nameOfDatabase;

    private JdbcService jdbcService;

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void makePreparation() {
        if(!jdbcService.isDatabaseExist(nameOfDatabase)) {
            jdbcService.createDatabase(nameOfDatabase);
        } else {
            System.out.println("Такая бд уже есть");
        }
    }
}
