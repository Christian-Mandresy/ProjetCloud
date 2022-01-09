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
public class StatusSignalement {
    private Integer IdStatus;
    private String NomStatus;
    
    public StatusSignalement(){
    
    }
    
    public StatusSignalement(Integer IdStatus,String NomStatus){
        this.IdStatus=IdStatus;
        this.NomStatus=NomStatus;
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
