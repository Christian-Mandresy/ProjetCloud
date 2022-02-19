package com.cloudproject.backoffice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="NotificationSignalement")
public class NotificationSignalement {

    @Id
    @GeneratedValue
    @Column(name = "IdNotification")
    private Integer IdNotification;
    
    @Column(name = "IdUtilisateur")
    private Integer IdUtilisateur;
    
    @Column(name = "DescriptionNotification")
    private String DescriptionNotification;
    
    @Column(name = "DateHeureNotification")
    private Timestamp DateHeureNotification;

    public NotificationSignalement() {

    }

    public NotificationSignalement(Integer IdNotification, Integer IdUtilisateur, String DescriptionNotification, Timestamp DateHeureNotification) {
        this.IdNotification = IdNotification;
        this.IdUtilisateur = IdUtilisateur;
        this.DescriptionNotification = DescriptionNotification;
        this.DateHeureNotification = DateHeureNotification;
    }

    public Integer getIdNotification() {
        return IdNotification;
    }

    public void setIdNotification(Integer IdNotification) {
        this.IdNotification = IdNotification;
    }

    public Integer getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(Integer IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public String getDescriptionNotification() {
        return DescriptionNotification;
    }

    public void setDescriptionNotification(String DescriptionNotification) {
        this.DescriptionNotification = DescriptionNotification;
    }

    public Timestamp getDateHeureNotification() {
        return DateHeureNotification;
    }

    public void setDateHeureNotification(Timestamp DateHeureNotification) {
        this.DateHeureNotification = DateHeureNotification;
    }

}
