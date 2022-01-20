package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List getAllUtilisateur();

    Utilisateur getUtilisateur(String user, String mdp);
}
