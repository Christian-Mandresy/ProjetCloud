package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TypeSignalement")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdType")
    private int IdType;

    @Column(name = "NomType")
    private String NomType;

    @Column(name = "Couleur")
    private String Couleur;

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }

    public String getNomType() {
        return NomType;
    }

    public void setNomType(String nomType) {
        NomType = nomType;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }
}
