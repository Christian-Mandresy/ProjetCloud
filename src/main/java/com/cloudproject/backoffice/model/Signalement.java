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
public class Signalement {

    private Integer IdSignalement;
    private Integer IdUtilisateur;
    private Integer IdType;
    private Integer IdStatus;
    private String DescriptionSignalement;
    private float Longitude;
    private float Latitude;
    private Timestamp DateHeureSignalement;

    public Signalement() {

    }

    public Signalement(Integer IdSignalement, Integer IdUtilisateur, Integer IdType, Integer IdStatus, String DescriptionSignalement, float Longitude, float Latitude, Timestamp DateHeureSignalement) {
        this.IdSignalement = IdSignalement;
        this.IdUtilisateur = IdUtilisateur;
        this.IdType = IdType;
        this.IdStatus = IdStatus;
        this.DescriptionSignalement = DescriptionSignalement;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.DateHeureSignalement = DateHeureSignalement;
    }

    public Integer getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(Integer IdSignalement) {
        this.IdSignalement = IdSignalement;
    }

    public Integer getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(Integer IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public Integer getIdType() {
        return IdType;
    }

    public void setIdType(Integer IdType) {
        this.IdType = IdType;
    }

    public Integer getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(Integer IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getDescriptionSignalement() {
        return DescriptionSignalement;
    }

    public void setDescriptionSignalement(String DescriptionSignalement) {
        this.DescriptionSignalement = DescriptionSignalement;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public Timestamp getDateHeureSignalement() {
        return DateHeureSignalement;
    }

    public void setDateHeureSignalement(Timestamp DateHeureSignalement) {
        this.DateHeureSignalement = DateHeureSignalement;
    }

}
