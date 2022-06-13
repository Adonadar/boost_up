package com.project.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.data.hibernate.entity.GeneralTable;

import java.util.List;

@Component
public class ActionPairNameDatabase {

    private SessionFactoryInitialization sessionFactoryInitialization;

    @Autowired
    public void setSessionFactoryInitialization(SessionFactoryInitialization sessionFactoryInitialization) {
        this.sessionFactoryInitialization = sessionFactoryInitialization;
    }

    public void addAsset(String nameOfPair, String period) {
        Session session = sessionFactoryInitialization.getSession();
        Transaction transaction = session.beginTransaction();
        boolean coinAlreadyExist = true;

        String sql = "from GeneralTable";
        List<GeneralTable> generalTableList = session.createQuery(sql).getResultList();

        for (GeneralTable generalTable: generalTableList) {
            if(generalTable.getAsset().equals(nameOfPair)) {
                if(generalTable.getPeriod().equals(period)) {
                    coinAlreadyExist = false;
                    break;
                }
            }
        }

        if(coinAlreadyExist) {
            GeneralTable generalTable = new GeneralTable(nameOfPair, period);
            session.save(generalTable);
        } else  {
            System.out.println("Такая пара уже есть в базе данных " + nameOfPair);
        }

        transaction.commit();
        session.close();
    }

    public void deleteAsset(String nameOfPair) {
        Session session = sessionFactoryInitialization.getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "delete GeneralTable where asset = " + "'" + nameOfPair + "'";
        session.createQuery(sql).executeUpdate();

        transaction.commit();
        session.close();
    }

    public List<GeneralTable> getAllAsset() {
        Session session = sessionFactoryInitialization.getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "from GeneralTable";
        List<GeneralTable> generalTables = session.createQuery(sql).getResultList();

        transaction.commit();
        session.close();

        return generalTables;
    }

    public boolean checkAsset(String nameOfPair, String period) {
        Session session = sessionFactoryInitialization.getSession();
        Transaction transaction = session.beginTransaction();
        boolean coinAlreadyExist = false;

        String sql = "from GeneralTable";
        List<GeneralTable> generalTableList = session.createQuery(sql).getResultList();

        for (GeneralTable generalTable: generalTableList) {
            if(generalTable.getAsset().equals(nameOfPair)) {
                if(generalTable.getPeriod().equals(period)) {
                    coinAlreadyExist = true;
                    break;
                }
            }
        }

        transaction.commit();
        session.close();

        return coinAlreadyExist;
    }
}
