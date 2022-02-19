package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.ResponsableRegion;
import java.util.List;

public interface ResponsableRegionService {
    public void insertResp(int idRegion, String nom, String prenom, String email, String motDePasse);

    public List<ResponsableRegion> findRespReg();

    public void updateRespReg(int IdResponsable, int idRegion, String nom, String prenom, String email, String motDePasse);

    public void deleteRespReg(int IdResponsable);
}
