package com.cloudproject.backoffice.model;

public class Region {

    private int IdRegion;
    private String NomRegion;

    public Region() {
    }

    public Region(int idRegion, String nomRegion) {
        IdRegion = idRegion;
        NomRegion = nomRegion;
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
}
