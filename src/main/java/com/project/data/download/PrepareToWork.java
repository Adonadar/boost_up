package com.project.data.download;

import com.project.data.connection.JdbcService;
import com.project.data.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrepareToWork {
    private JdbcService jdbcService;

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void makePreparation() {
        if(!jdbcService.isDatabaseExist(Constant.NAME_OF_DATABASE)) {
            jdbcService.createDatabase(Constant.NAME_OF_DATABASE);
        } else {
            System.out.println("Такая бд уже есть");
        }
    }
}
