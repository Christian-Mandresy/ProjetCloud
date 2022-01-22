package com.cloudproject.backoffice.model;

import org.springframework.context.annotation.Bean;

import javax.validation.constraints.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ResponsableRegion")
public class ResponsableRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdResponsable")
    private int IdResponsable;

    @Column(name = "IdRegion")
    private int IdRegion;

    @NotBlank
    @Column(name = "Nom")
    private String Nom;

    @NotBlank
    @Column(name = "Prenom")
    private String Prenom;

    @NotBlank
    @Column(name = "Email")
    private String Email;

    @NotBlank
    @Column(name = "MotDePasse")
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
