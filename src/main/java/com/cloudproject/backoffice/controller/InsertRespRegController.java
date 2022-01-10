package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.ResponsableRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;



@Controller
public class InsertRespRegController {
    private ResponsableRegionService responsableRegionService;
    private RegionService regionService;

    @Autowired
    public void setResponsableRegionService(ResponsableRegionService responsableRegionService) {
        this.responsableRegionService = responsableRegionService;
    }

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @RequestMapping(value = "/insertResp", method = RequestMethod.POST)
    public String insertResp(@ModelAttribute("ResponsableRegion") @Validated ResponsableRegion responsableRegion,
                             BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("ResponsableRegion",responsableRegion);
            model.addAttribute("ListRegion",regionService.getRegion());
            return "FormRespRegion";
        }
        else
        {
            responsableRegionService.insertResp(Integer.parseInt(request.getParameter("idRegion")),request.getParameter("Nom"),request.getParameter("Prenom"),request.getParameter("Email"),request.getParameter("MotDePasse"));
            model.addAttribute("ResponsableRegion",responsableRegion);
            model.addAttribute("ListRegion",regionService.getRegion());
            model.addAttribute("success","insertion reussie");
            return "FormRespRegion";
        }

    }

}

