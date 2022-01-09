package com.cloudproject.backoffice.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
public class Photos {

    private Integer IdSignalement;
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
