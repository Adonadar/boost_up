package com.project.data.hibernate;

import com.project.constant.Constant;
import com.project.data.hibernate.entity.GeneralTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryInitialization {

    private SessionFactory sessionFactory;

    private Session session;

    public Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.getProperties().setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + Constant.NAME_OF_DATABASE);
        try {
            sessionFactory = cfg.addAnnotatedClass(GeneralTable.class).buildSessionFactory();
        } catch (Exception ex) {
            System.out.println("Возможно перед началом работы не запущен preparation");
            ex.printStackTrace();
        }

        session = sessionFactory.getCurrentSession();

        return session;
    }
}
