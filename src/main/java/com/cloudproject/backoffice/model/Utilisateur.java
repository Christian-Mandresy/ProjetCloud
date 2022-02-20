package com.cloudproject.backoffice.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUtilisateur")
    private Integer IdUtilisateur;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Prenom")
    private String Prenom;

    @Column(name = "DateNaissance")
    private Timestamp DateNaissance;

    @NotBlank
    @Column(name = "Email")
    private String Email;

    @NotEmpty
    @Column(name = "MotDePasse")
    private String MotDePasse;

    @Column(name = "Sexe")
    private String Sexe;

    @Column(name = "Contact")
    private String Contact;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Utilisateur() {

    }

    public Utilisateur(String email, String motDePasse) {
        Email = email;
        MotDePasse = motDePasse;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
