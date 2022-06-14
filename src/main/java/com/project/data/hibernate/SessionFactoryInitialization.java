package com.project.data.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.project.data.hibernate.entity.GeneralTable;

@Component
public class SessionFactoryInitialization {
    @Value("${create.database.name}")
    private String nameOfDatabase;

    private SessionFactory sessionFactory;

    private Session session;

    public Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.getProperties().setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + nameOfDatabase);
        try {
            sessionFactory = cfg.addAnnotatedClass(GeneralTable.class).buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        session = sessionFactory.getCurrentSession();

        return session;
    }
}
