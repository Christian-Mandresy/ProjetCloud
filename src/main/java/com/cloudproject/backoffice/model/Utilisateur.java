package com.cloudproject.backoffice.model;

import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
public class Utilisateur {

    private Integer IdUtilisateur;
    private String Nom;
    private String Prenom;
    private Timestamp DateNaissance;
    private String Email;
    private String MotDePasse;
    private String Sexe;
    private String Contact;

    public Utilisateur() {

    }

    public Utilisateur(Integer IdUtilisateur, String Nom, String Prenom, Timestamp DateNaissance, String Email, String MotDePasse, String Sexe, String Contact) {
        this.IdUtilisateur = IdUtilisateur;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.DateNaissance = DateNaissance;
        this.Email = Email;
        this.MotDePasse = MotDePasse;
        this.Sexe = Sexe;
        this.Contact = Contact;
    }

    public Integer getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(Integer IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Timestamp getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Timestamp DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

}
