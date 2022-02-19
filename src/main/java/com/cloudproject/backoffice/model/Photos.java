package com.cloudproject.backoffice.model;

import java.io.Serializable;
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
@Table(name="Photos")
public class Photos {

    @Id
    @GeneratedValue
    @Column(name = "IdSignalement")
    private Integer IdSignalement;
    
    @Column(name = "Photos")
    private String Photos;

    public Photos() {

    }

    public Photos(Integer IdSignalement, String Photos) {
        this.IdSignalement = IdSignalement;
        this.Photos = Photos;
    }

    public Integer getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(Integer IdSignalement) {
        this.IdSignalement = IdSignalement;
    }

    public String getPhotos() {
        return Photos;
    }

    public void setPhotos(String Photos) {
        this.Photos = Photos;
    }

}
