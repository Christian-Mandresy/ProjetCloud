package com.cloudproject.backoffice.service.impl;


import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
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
    public List getAllUtilisateur()
    {
        return utilisateurDao.getAllUtilisateur();
    }

    @Override
    public Utilisateur getUtilisateur(String user, String mdp)
    {
        return utilisateurDao.getUtilisateur(user,mdp);
    }

    @Override
    public void save(Utilisateur utilisateur)
    {
        utilisateurDao.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurByName(String name)
    {
        return utilisateurDao.getUtilisateurByName(name);
    }
}
