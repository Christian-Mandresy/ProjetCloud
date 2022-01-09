package com.cloudproject.backoffice.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
public class TypeSignalement {

    private Integer IdType;
    private String NomType;
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
