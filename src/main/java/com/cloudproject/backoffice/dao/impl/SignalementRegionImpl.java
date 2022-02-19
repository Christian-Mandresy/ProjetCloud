/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.SignalementRegionDao;
import com.cloudproject.backoffice.model.SignalementRegion;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author samko
 */

@Repository("SignalementRegionDao")
public class SignalementRegionImpl implements SignalementRegionDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertSignalementRegion(Integer IdSignalement,Integer IdRegion,Date DateAffectation){
        Session session = this.sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            SignalementRegion sreg=new SignalementRegion();
            sreg.setIdSignalement(IdSignalement);
            sreg.setIdRegion(IdRegion);
            sreg.setDateAffectation(DateAffectation);
            session.save(sreg);
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
