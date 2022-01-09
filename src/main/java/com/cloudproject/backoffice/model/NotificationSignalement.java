package com.cloudproject.backoffice.model;

import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
public class NotificationSignalement {

    private Integer IdNotification;
    private Integer IdUtilisateur;
    private String DescriptionNotification;
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
