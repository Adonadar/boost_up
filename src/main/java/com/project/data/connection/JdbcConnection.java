package com.project.data.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class JdbcConnection {

    @Value("${CreatorTableJdbc.databaseUrl}")
    private String databaseUrl;

    @Value("${CreatorTableJdbc.jdbcDriver}")
    private String jdbcDriver;

    @Value("${CreatorTableJdbc.user}")
    private String user;

    @Value("${CreatorTableJdbc.password}")
    private String password;

    public Connection getConnection() {
        Connection connection;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(databaseUrl, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
