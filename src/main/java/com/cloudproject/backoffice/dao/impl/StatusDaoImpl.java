package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.StatusDao;
import com.cloudproject.backoffice.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StatusDao")
public class StatusDaoImpl implements StatusDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Status> getStatus() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List status = session.createCriteria(Status.class).list();
            tx.commit();
            return status;
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
