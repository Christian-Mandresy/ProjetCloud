package com.cloudproject.backoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SignalementRegion")
public class SignalementRegion {

    @Id
    @Column(name = "IdSignalement")
    private int IdSignalement;

    @Column(name = "IdRegion")
    @Id
    private int IdRegion;

    @Column(name = "DateAffection")
    private Date DateAffection;

    public int getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        IdSignalement = idSignalement;
    }

    public int getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(int idRegion) {
        IdRegion = idRegion;
    }

    public Date getDateAffection() {
        return DateAffection;
    }

    public void setDateAffection(Date dateAffection) {
        DateAffection = dateAffection;
    }
}
