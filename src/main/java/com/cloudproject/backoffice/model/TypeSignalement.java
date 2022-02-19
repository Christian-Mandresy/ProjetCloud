package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "TypeSignalement")
public class TypeSignalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdType")
    private Integer IdType;
    
    @Column(name = "NomType")
    private String NomType;
    
    @Column(name = "Couleur")
    private String Couleur;

    public TypeSignalement() {

    }

    public TypeSignalement(Integer IdType, String NomType, String Couleur) {
        this.IdType = IdType;
        this.NomType = NomType;
        this.Couleur = Couleur;
    }

    public Integer getIdType() {
        return IdType;
    }

    public void setIdType(Integer IdType) {
        this.IdType = IdType;
    }

    public String getNomType() {
        return NomType;
    }

    public void setNomType(String NomType) {
        this.NomType = NomType;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String Couleur) {
        this.Couleur = Couleur;
    }

}
