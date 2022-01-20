package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.StatGlobaleDao;
import com.cloudproject.backoffice.model.StatGlobale;
import com.cloudproject.backoffice.model.StatistiqueCriteriaRegion;
import com.cloudproject.backoffice.model.Status;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StatGlobaleDao")
public class StatGlobaleDaoImpl implements StatGlobaleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getStatRegion()
    {
        Session session = this.sessionFactory.openSession();
        try {
            SQLQuery query= session.createSQLQuery("select * from signalementparregion")
                    .addEntity(StatGlobale.class);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List getStatType()
    {
        Session session = this.sessionFactory.openSession();
        try {
            SQLQuery query= session.createSQLQuery("select * from signalementpartype")
                    .addEntity(StatGlobale.class);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List getStatStatus()
    {
        Session session = this.sessionFactory.openSession();
        try {
            SQLQuery query= session.createSQLQuery("select * from signalementparstatus")
                    .addEntity(StatGlobale.class);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
