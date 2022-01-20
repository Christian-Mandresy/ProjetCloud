package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.SignalementDao;
import com.cloudproject.backoffice.model.Signalement;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SignalementDao")
public class SignalementDaoImpl implements SignalementDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllSign()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(Signalement.class).list();
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

    @Override
    public List getNonAssigner()
    {
        Session session = this.sessionFactory.openSession();
        try {
            SQLQuery query= session.createSQLQuery("select * from NonAssigner")
                    .addEntity(Signalement.class);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Signalement getSign(int id)
    {
        Session session = this.sessionFactory.openSession();
        try{
            Criteria criteria = session.createCriteria(Signalement.class);
            Criterion critere = Restrictions.eq("IdSignalement", id);
            criteria.add(critere);
            List personnes = criteria.list();
            return (Signalement) personnes.get(0);
        }catch (Exception e)
        {
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public List getSignRegion(int IdRegion)
    {
        Session session = this.sessionFactory.openSession();
        try{
            String sql="select IdSignalement, IdUtilisateur, IdType, IdStatus, DescriptionSignalement, Longitude, Latitude, DateHeureSignalement from SignalEtRegion where IdRegion = "+"'"+IdRegion+"'";
            SQLQuery query= session.createSQLQuery(sql)
                    .addEntity(Signalement.class);
            return query.list();
        }catch (Exception e)
        {
            throw e;
        }finally {
            session.close();
        }
    }

}
