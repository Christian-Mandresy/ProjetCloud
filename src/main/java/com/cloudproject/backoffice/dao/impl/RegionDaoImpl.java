package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.RegionDao;
import com.cloudproject.backoffice.model.Region;
import com.cloudproject.backoffice.model.Signalement;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("regionDao")
@Transactional
public class RegionDaoImpl implements RegionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Region> getRegion() {
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            List region = session.createCriteria(Region.class).list();
            tx.commit();
            return region;
        }
        catch (Exception e)
        {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }

    }

    @Override
    public Region getByRegionName(String name)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Criteria criteria=session .createCriteria(Region.class);
            Criterion critere = Restrictions.eq("IdRegion", name);
            criteria.add(critere);
            tx.commit();
            List valiny=criteria.list();
            return (Region)valiny.get(0);
        }
        catch (Exception e)
        {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }

}
