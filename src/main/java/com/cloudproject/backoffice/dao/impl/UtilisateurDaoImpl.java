package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UtilisateurDao")
public class UtilisateurDaoImpl implements UtilisateurDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllUtilisateur()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List utilisateura = session.createCriteria(Utilisateur.class).list();
            tx.commit();
            return utilisateura;
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
    public Utilisateur getUtilisateur(String util, String mdp)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Utilisateur.class);
            Criterion critere = Restrictions.eq("Email", util);
            Criterion critere1 = Restrictions.eq("MotDePasse", mdp);
            criteria.add(critere);
            criteria.add(critere1);
            List valiny=criteria.list();
            if (valiny.size()==0)
            {
                return new Utilisateur();
            }
            else
            {
                Utilisateur utilisa=(Utilisateur) valiny.get(0);
                tx.commit();
                return utilisa;
            }

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
    public Utilisateur getUtilisateurByName(String util)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Utilisateur.class);
            Criterion critere = Restrictions.eq("Email", util);
            criteria.add(critere);
            List valiny=criteria.list();
            if (valiny.size()==0)
            {
                return null;
            }
            else
            {
                Utilisateur utilisa=(Utilisateur) valiny.get(0);
                tx.commit();
                return utilisa;
            }

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
    public void save(Utilisateur utilisateur)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            session.save(utilisateur);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }
}
