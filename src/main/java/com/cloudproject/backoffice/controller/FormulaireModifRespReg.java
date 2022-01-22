/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Region;
import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.ResponsableRegionService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author samko
 */
@Controller
public class FormulaireModifRespReg {

    private RegionService regServ;
    private ResponsableRegionService respReg;

    @Autowired
    public void setRegServ(RegionService regServ) {
        this.regServ = regServ;
    }

    @Autowired
    public void setRespReg(ResponsableRegionService respReg) {
        this.respReg = respReg;
    }

    @GetMapping("/FormModifRespReg")
    public String afficheRespReg(Map modelMap) {
        List<Region> regionList = regServ.getRegion();
        List<ResponsableRegion> responsableList = respReg.findRespReg();

        modelMap.put("ResponsableRegion", new ResponsableRegion());
        modelMap.put("listRespReg", responsableList);
        modelMap.put("listRegion", regionList);

        return "modifRespReg";
    }
}
