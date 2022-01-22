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
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author samko
 */
@Controller
public class ModifResp {

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

    @RequestMapping(value = "/UpdateRespReg", method = RequestMethod.POST)
    public String UpdateResponsableRegion(@ModelAttribute("ResponsableRegion") @Validated ResponsableRegion responsableRegion,
            BindingResult bindingResult, Model modelMap, HttpServletRequest request) {
        List<Region> regionList = regServ.getRegion();
        List<ResponsableRegion> responsableList = respReg.findRespReg();

        for (int i = 0; i < regionList.size(); i++) {
            if (regionList.get(i).getNomRegion().equals(request.getParameter("IdRegion"))) {
                respReg.updateRespReg(Integer.parseInt(request.getParameter("IdResponsable")), regionList.get(i).getIdRegion(), request.getParameter("Nom"),  request.getParameter("Prenom"),  request.getParameter("Email"),  request.getParameter("MotDePasse"));

                modelMap.addAttribute("ResponsableRegion", new ResponsableRegion());
                modelMap.addAttribute("listRespReg", responsableList);
                modelMap.addAttribute("listRegion", regionList);
                return "modifRespReg";
            } else {
            }
        }
        return "modifRespReg";
    }
}
