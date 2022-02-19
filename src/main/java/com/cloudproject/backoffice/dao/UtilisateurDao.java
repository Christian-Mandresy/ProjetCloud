package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Utilisateur;
import java.sql.Timestamp;
import java.util.Date;

import java.util.List;

public interface UtilisateurDao {
    List<Utilisateur> getAllUtilisateur();

    Utilisateur getUtilisateur(String util, String mdp);

    void DeleteUtilisateur(int IdUtilisateur);

    void InsertUtilisateur(String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact);

    void UpdateUtilisateur(int IdUtilisateur, String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact);
}
