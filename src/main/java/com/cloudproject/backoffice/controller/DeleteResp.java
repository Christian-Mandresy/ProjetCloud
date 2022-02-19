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
public class DeleteResp {
    private RegionService regServ;
    private ResponsableRegionService respReg;

    @Autowired
    public void setRespReg(ResponsableRegionService respReg) {
        this.respReg = respReg;
    }

    @Autowired
    public void setRegServ(RegionService regServ) {
        this.regServ = regServ;
    }

    @RequestMapping(value = "/DeleteRespReg", method = RequestMethod.POST)
    public String deleteRespReg(@ModelAttribute("ResponsableRegion") @Validated ResponsableRegion responsableRegion,
            BindingResult bindingResult, Model modelMap, HttpServletRequest request) {
        
        respReg.deleteRespReg(Integer.parseInt(request.getParameter("IdResponsable")));
        
        List<Region> newRegionList = regServ.getRegion();
        List<ResponsableRegion> newResponsableList = respReg.findRespReg();

        modelMap.addAttribute("ResponsableRegion", new ResponsableRegion());
        modelMap.addAttribute("listRespReg", newResponsableList);
        modelMap.addAttribute("listRegion", newRegionList);

        return "modifRespReg";
    }
}
