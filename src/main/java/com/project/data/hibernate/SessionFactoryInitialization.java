package com.project.data.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import com.project.data.hibernate.entity.GeneralTable;

@Component
public class SessionFactoryInitialization {
    private SessionFactory sessionFactory;

    private Session session;

    public Session getSession() {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(GeneralTable.class)
                    .buildSessionFactory();;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        session = sessionFactory.getCurrentSession();

        return session;
    }
}
