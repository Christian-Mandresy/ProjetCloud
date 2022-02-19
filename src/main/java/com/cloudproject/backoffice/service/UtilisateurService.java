package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.Utilisateur;
import java.sql.Timestamp;
import java.util.Date;

import java.util.List;

public interface UtilisateurService {
    public List getAllUtilisateur();

    public Utilisateur getUtilisateur(String user, String mdp);

    public void DeleteUtilisateur(int IdUtilisateur);

    public void InsertUtilisateur(String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact);

    public void UpdateUtilisateur(int IdUtilisateur, String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact);
}
