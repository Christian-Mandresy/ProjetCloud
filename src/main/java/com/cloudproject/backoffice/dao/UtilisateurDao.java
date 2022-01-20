package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    List getAllUtilisateur();

    Utilisateur getUtilisateur(String util, String mdp);
}
