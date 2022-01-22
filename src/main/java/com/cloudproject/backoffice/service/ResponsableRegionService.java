package com.cloudproject.backoffice.service;

import java.util.List;

public interface ResponsableRegionService {
    public void insertResp(int idRegion, String nom, String prenom, String email, String motDePasse);

    public List findRespReg();

    public void updateRespReg(int idResponsable, int idRegion, String nom, String prenom, String email, String motDePasse);
}
