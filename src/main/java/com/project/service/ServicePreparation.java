package com.project.service;

import com.project.data.connection.JdbcService;
import com.project.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicePreparation {
    private JdbcService jdbcService;

    private ServiceInternetConnectionCheck internetConnectionCheck;

    private ServiceCreateDirectory serviceCreateDirectory;

    @Autowired
    public void setJdbcService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Autowired
    public void setInternetConnectionCheck(ServiceInternetConnectionCheck internetConnectionCheck) {
        this.internetConnectionCheck = internetConnectionCheck;
    }

    @Autowired
    public void setServiceCreateDirectory(ServiceCreateDirectory serviceCreateDirectory) {
        this.serviceCreateDirectory = serviceCreateDirectory;
    }

    public void start() {
        if(!internetConnectionCheck.check()) {
            // exception
            return;
        }

        if(!jdbcService.isDatabaseExist(Constant.NAME_OF_DATABASE)) {
            jdbcService.createDatabase(Constant.NAME_OF_DATABASE);
        } else {
            System.out.println("Такая бд уже есть");
        }

        serviceCreateDirectory.create(Constant.PATH_TO_DIRECTORY);
    }
}
