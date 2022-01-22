package com.cloudproject.backoffice.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="StatistiqueCriteriaRegionDao")
public class StatistiqueCriteriaRegion {

    @Id
    @Column(name = "IdSignalement")
    private int IdSignalement;

    @Column(name = "IdUtilisateur")
    private int IdUtilisateur;

    @Column(name = "IdType")
    private int IdType;

    @Column(name = "IdStatus")
    private int IdStatus;

    @Column(name = "DescriptionSignalement")
    private String DescriptionSignalement;

    @Column(name="Longitude")
    private float Longitude;

    @Column(name = "Latitude")
    private float Latitude;

    @Column(name = "DateHeureSignalement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateHeureSignalement;

    @Column(name = "IdRegion")
    private int IdRegion;

    @Column(name = "NomRegion")
    private String NomRegion;

    @Column(name = "Nombre")
    private int Nombre;


    public int getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        IdSignalement = idSignalement;
    }

    public int getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    public int getIdType() {
        return IdType;
    }

    public void setIdType(int idType) {
        IdType = idType;
    }

    public int getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(int idStatus) {
        IdStatus = idStatus;
    }

    public String getDescriptionSignalement() {
        return DescriptionSignalement;
    }

    public void setDescriptionSignalement(String descriptionSignalement) {
        DescriptionSignalement = descriptionSignalement;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public Date getDateHeureSignalement() {
        return DateHeureSignalement;
    }

    public void setDateHeureSignalement(Date dateHeureSignalement) {
        DateHeureSignalement = dateHeureSignalement;
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

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int nombre) {
        Nombre = nombre;
    }
}
