package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDao utilisateurDao;
    
    @Autowired
    public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
    
    @Override
    public List getAllUtilisateur() {
        return utilisateurDao.getAllUtilisateur();
    }
    
    @Override
    public Utilisateur getUtilisateur(String user, String mdp) {
        return utilisateurDao.getUtilisateur(user, mdp);
    }
    
    @Override
    public void InsertUtilisateur(String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact) {
        utilisateurDao.InsertUtilisateur(Nom, Prenom, DateNaissance, Email, MotDePasse, Sexe, Contact);
    }
    
    @Override
    public void UpdateUtilisateur(int IdUtilisateur, String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact) {
        utilisateurDao.UpdateUtilisateur(IdUtilisateur, Nom, Prenom, DateNaissance, Email, MotDePasse, Sexe, Contact);
    }
    
    @Override
    public void DeleteUtilisateur(int IdUtilisateur){
        utilisateurDao.DeleteUtilisateur(IdUtilisateur);
    }
}
