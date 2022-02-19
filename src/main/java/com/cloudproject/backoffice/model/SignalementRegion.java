/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author samko
 */

@Entity
@Table(name = "SignalementRegion")
public class SignalementRegion {
    
    @Id
    @Column(name = "IdSignalement")
    Integer IdSignalement;
    
    @Column(name = "IdRegion")
    Integer IdRegion;
    
    @Column(name = "DateAffectation")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date DateAffectation;
    
    public SignalementRegion(){
    
    }
    
    public SignalementRegion(Integer IdSignalement,Integer IdRegion,Date DateAffectation){
        this.IdSignalement=IdSignalement;
        this.IdRegion=IdRegion;
        this.DateAffectation=DateAffectation;
    }

    public Integer getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(Integer IdSignalement) {
        this.IdSignalement = IdSignalement;
    }

    public Integer getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(Integer IdRegion) {
        this.IdRegion = IdRegion;
    }

    public Date getDateAffectation() {
        return DateAffectation;
    }

    public void setDateAffectation(Date DateAffectation) {
        this.DateAffectation = DateAffectation;
    }
}
