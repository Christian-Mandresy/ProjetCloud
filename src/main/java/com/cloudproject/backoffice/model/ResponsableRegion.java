package com.cloudproject.backoffice.model;

public class ResponsableRegion {
    private int IdResponsable;
    private int IdRegion;
    private String Nom;
    private String Prenom;
    private String Email;
    private String MotDePasse;

    public ResponsableRegion() {
    }

    public ResponsableRegion(int idResponsable, int idRegion, String nom, String prenom, String email, String motDePasse) {
        IdResponsable = idResponsable;
        IdRegion = idRegion;
        Nom = nom;
        Prenom = prenom;
        Email = email;
        MotDePasse = motDePasse;
    }

    public int getIdResponsable() {
        return IdResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        IdResponsable = idResponsable;
    }

    public int getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(int idRegion) {
        IdRegion = idRegion;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }
}
