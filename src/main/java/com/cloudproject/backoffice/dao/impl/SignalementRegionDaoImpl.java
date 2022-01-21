package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.model.SignalementRegion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SignalementRegionDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public List getAllSign()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(SignalementRegion.class).list();
            tx.commit();
            return type;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
