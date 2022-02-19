package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Region")
public class Region {

    @Id
    @GeneratedValue
    @Column(name = "IdRegion")
    private int IdRegion;

    @Column(name = "NomRegion")
    private String NomRegion;

    public Region() {
    }

    public Region(int idRegion, String nomRegion) {
        IdRegion = idRegion;
        NomRegion = nomRegion;
    }

    public int getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(int idRegion) {
        IdRegion = idRegion;
    }

    public String getNomRegion() {
        return NomRegion;
    }

    public void setNomRegion(String nomRegion) {
        NomRegion = nomRegion;
    }
}
