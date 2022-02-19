/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.AdministrateurDao;
import com.cloudproject.backoffice.model.Administrateur;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samko
 */
@Repository("AdministrateurDao")
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
public class AdministrateurDaoImpl implements AdministrateurDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List getAllAdmin()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List admin = session.createCriteria(Administrateur.class).list();
            tx.commit();
            return admin;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Administrateur getAdmin(String email, String mdp)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Administrateur.class);
            Criterion critere = Restrictions.eq("Email", email);
            Criterion critere1 = Restrictions.eq("MotDePasse", mdp);
            criteria.add(critere);
            criteria.add(critere1);
            List valiny=criteria.list();
            if (valiny.isEmpty())
            {
                return new Administrateur();
            }
            else
            {
                Administrateur utilisa=(Administrateur) valiny.get(0);
                tx.commit();
                return utilisa;
            }

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public void InsertAdmin(String NomAdmin,String PrenomAdmin,String Email,String MotDePasse){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Administrateur admin=new Administrateur();
            admin.setNomAdmin(NomAdmin);
            admin.setPrenomAdmin(PrenomAdmin);
            admin.setEmail(Email);
            admin.setMotDePasse(MotDePasse);
            session.save(admin);
            tx.commit();
        }catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }finally{
            session.close();
        }
    }
    
    @Override
    public void UpdateAdmin(int idAdmin, String NomAdmin,String PrenomAdmin,String Email,String MotDePasse){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Administrateur admin=new Administrateur();
            admin.setIdAdmin(idAdmin);
            admin.setNomAdmin(NomAdmin);
            admin.setPrenomAdmin(PrenomAdmin);
            admin.setEmail(Email);
            admin.setMotDePasse(MotDePasse);
            session.saveOrUpdate(admin);
            tx.commit();
        }catch(Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }finally{
            session.close();
        }
    }
}