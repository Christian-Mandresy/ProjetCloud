package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.ResponsableRegion;

import java.util.List;

public interface ResponsableRegionDao {
    List<ResponsableRegion> getRespRegion();

    void InsertRespRegion(int idRegion, String nom, String prenom, String email, String motDePasse);
}
