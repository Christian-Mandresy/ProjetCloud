package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StatGlobale")
public class StatGlobale {
    @Id
    @Column(name = "Id")
    private int Id;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Nombre")
    private int Nombre;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int nombre) {
        Nombre = nombre;
    }
}
