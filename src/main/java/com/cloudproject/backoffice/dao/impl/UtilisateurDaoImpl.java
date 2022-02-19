package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.Utilisateur;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.HibernateException;

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
            if (valiny.isEmpty())
            {
                return new Utilisateur();
            }
            else
            {
                Utilisateur utilisa=(Utilisateur) valiny.get(0);
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
    public void InsertUtilisateur(String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse,String Sexe,String Contact){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Utilisateur user=new Utilisateur();
            user.setNom(Nom);
            user.setPrenom(Prenom);
            user.setDateNaissance(DateNaissance);
            user.setEmail(Email);
            user.setMotDePasse(MotDePasse);
            user.setSexe(Sexe);
            user.setContact(Contact);
            session.save(user);
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
    public void DeleteUtilisateur(int IdUtilisateur){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Utilisateur user=new Utilisateur();
            user.setIdUtilisateur(IdUtilisateur);
            session.delete(user);
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
    public void UpdateUtilisateur(int IdUtilisateur, String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse,String Sexe,String Contact){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Utilisateur user=new Utilisateur();
            user.setIdUtilisateur(IdUtilisateur);
            user.setNom(Nom);
            user.setPrenom(Prenom);
            user.setDateNaissance(DateNaissance);
            user.setEmail(Email);
            user.setMotDePasse(MotDePasse);
            user.setSexe(Sexe);
            user.setContact(Contact);
            session.saveOrUpdate(user);
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
