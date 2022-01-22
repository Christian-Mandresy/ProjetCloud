package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.ResponsableRegionDao;
import com.cloudproject.backoffice.model.ResponsableRegion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("responsableRegionDao")
@Transactional
public class ResponsableRegionDaoImpl implements ResponsableRegionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ResponsableRegion> getRespRegion() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            List responsableRegion = session.createCriteria(ResponsableRegion.class).list();
            tx.commit();
            return responsableRegion;
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
    public void InsertRespRegion(int idRegion, String nom, String prenom, String email, String motDePasse) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ResponsableRegion resp = new ResponsableRegion();
            resp.setIdRegion(idRegion);
            resp.setNom(nom);
            resp.setPrenom(prenom);
            resp.setEmail(email);
            resp.setMotDePasse(motDePasse);
            session.save(resp);
            tx.commit();
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
    public void UpdateRespRegion(int idResponsable, int idRegion, String nom, String prenom, String email, String motDePasse) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ResponsableRegion resp = new ResponsableRegion();
            resp.setIdResponsable(idResponsable);
            resp.setIdRegion(idRegion);
            resp.setNom(nom);
            resp.setPrenom(prenom);
            resp.setEmail(email);
            resp.setMotDePasse(motDePasse);
            session.update(resp);
            tx.commit();
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
