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
@Table(name = "StatusSignalement")
public class StatusSignalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdStatus")
    private Integer IdStatus;
    
    @Column(name = "NomStatus")
    private String NomStatus;

    public StatusSignalement() {

    }

    public StatusSignalement(Integer IdStatus, String NomStatus) {
        this.IdStatus = IdStatus;
        this.NomStatus = NomStatus;
    }

    public Integer getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(Integer IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getNomStatus() {
        return NomStatus;
    }

    public void setNomStatus(String NomStatus) {
        this.NomStatus = NomStatus;
    }

}
