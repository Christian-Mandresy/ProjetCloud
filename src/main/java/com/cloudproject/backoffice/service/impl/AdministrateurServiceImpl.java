/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.AdministrateurDao;
import com.cloudproject.backoffice.model.Administrateur;
import com.cloudproject.backoffice.service.AdministrateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samko
 */
@Service("AdministrateurService")
public class AdministrateurServiceImpl implements AdministrateurService {
    AdministrateurDao adminDao;

    @Autowired
    public void setAdminDao(AdministrateurDao adminDao) {
        this.adminDao = adminDao;
    }
    
    @Override
    public void insertAdmin(String NomAdmin, String PrenomAdmin, String Email, String MotDePasse){
        adminDao.InsertAdmin(NomAdmin, PrenomAdmin, Email, MotDePasse);
    }
    
    @Override
    public void updateAdmin(int idAdmin, String NomAdmin, String PrenomAdmin, String Email, String MotDePasse){
        adminDao.UpdateAdmin(idAdmin, NomAdmin, PrenomAdmin, Email, MotDePasse);
    }
    
    @Override
    public Administrateur getAdmin(String email, String mdp){
        return adminDao.getAdmin(email, mdp);
    }
    
    @Override
    public List getAllAdmin(){
        return adminDao.getAllAdmin();
    }
}
