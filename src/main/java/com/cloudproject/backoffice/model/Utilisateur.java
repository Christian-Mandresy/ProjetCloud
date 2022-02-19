package com.cloudproject.backoffice.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUtilisateur")
    private Integer IdUtilisateur;

    @NotBlank
    @Column(name = "Nom")
    private String Nom;

    @NotBlank
    @Column(name = "Prenom")
    private String Prenom;

    @NotBlank
    @Column(name = "DateNaissance")
    private String DateNaissance;

    @NotBlank
    @Column(name = "Email")
    private String Email;

    @NotBlank
    @Column(name = "MotDePasse")
    private String MotDePasse;

    @NotBlank
    @Column(name = "Sexe")
    private String Sexe;

    @NotBlank
    @Column(name = "Contact")
    private String Contact;

    public Utilisateur() {

    }

    public Utilisateur(Integer IdUtilisateur, String Nom, String Prenom, String DateNaissance, String Email, String MotDePasse, String Sexe, String Contact) {
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

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
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
