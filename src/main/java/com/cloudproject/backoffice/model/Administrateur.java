/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samko
 */
@Entity
@Table(name = "Administrateur")
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdmin")
    private int idAdmin;

    @Column(name = "NomAdmin")
    private String NomAdmin;

    @Column(name = "PrenomAdmin")
    private String PrenomAdmin;

    @NotBlank
    @Column(name = "Email")
    private String Email;

    @NotBlank
    @Column(name = "MotDePasse")
    private String MotDePasse;

    public Administrateur(){
    
    }
    
    public Administrateur(int idAdmin, String NomAdmin,String PrenomAdmin,String Email,String MotDePasse) {
        this.idAdmin=idAdmin;
        this.NomAdmin=NomAdmin;
        this.PrenomAdmin=PrenomAdmin;
        this.Email=Email;
        this.MotDePasse=MotDePasse;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return NomAdmin;
    }

    public void setNomAdmin(String NomAdmin) {
        this.NomAdmin = NomAdmin;
    }

    public String getPrenomAdmin() {
        return PrenomAdmin;
    }

    public void setPrenomAdmin(String PrenomAdmin) {
        this.PrenomAdmin = PrenomAdmin;
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

}
