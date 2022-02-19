package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.ResponsableRegionDao;
import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.ResponsableRegionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ResponsableRegionService")
public class ResponsableRegionServiceImpl implements ResponsableRegionService {
    private ResponsableRegionDao responsableRegionDao;

    @Autowired
    public void setResponsableRegionDao(ResponsableRegionDao responsableRegionDao) {
        this.responsableRegionDao = responsableRegionDao;
    }

    @Override
    public void insertResp(int idRegion, String nom, String prenom, String email, String motDePasse) {
        responsableRegionDao.InsertRespRegion(idRegion,nom,prenom,email,motDePasse);
    }
    
    @Override
    public List<ResponsableRegion> findRespReg(){
        return responsableRegionDao.getRespRegion();
    }
    
    @Override
    public void updateRespReg(int IdResponsable, int idRegion, String nom, String prenom, String email, String motDePasse){
        responsableRegionDao.UpdateRespRegion(IdResponsable, idRegion, nom, prenom, email, motDePasse);
    }
    
    @Override
    public void deleteRespReg(int IdResponsable){
        responsableRegionDao.DeleteRespRegion(IdResponsable);
    }
}
