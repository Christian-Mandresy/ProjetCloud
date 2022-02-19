/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.SignalementRegionDao;
import com.cloudproject.backoffice.service.SignalementRegionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author samko
 */
@Service("SignalementRegionService")
public class SignalementRegionServiceImpl implements SignalementRegionService {
    
    private SignalementRegionDao sign;

    @Autowired
    public void setSign(SignalementRegionDao sign) {
        this.sign = sign;
    }
    
    @Override
    public void insertSignalementRegion(Integer IdSignalement, Integer IdRegion, Date DateAffectation){
        sign.insertSignalementRegion(IdSignalement, IdRegion, DateAffectation);
    }
}
