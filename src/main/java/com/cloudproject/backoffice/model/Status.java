package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "StatusSignalement")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdStatus")
    private int IdStatus;

    @Column(name = "NomStatus")
    private String NomStatus;

    public int getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(int idStatus) {
        IdStatus = idStatus;
    }

    public String getNomStatus() {
        return NomStatus;
    }

    public void setNomStatus(String nomStatus) {
        NomStatus = nomStatus;
    }
}
