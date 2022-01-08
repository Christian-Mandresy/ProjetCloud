package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class FormulaireInsertRespController {
    private RegionServiceImpl regionService;

    @Autowired
    public void setRegionService(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }

    @RequestMapping("/formRespRegion")
    public String initForm(ModelMap modelMap)
    {
        ResponsableRegion responsableRegion=new ResponsableRegion();
        modelMap.addAttribute("ResponsableRegion",responsableRegion);
        modelMap.addAttribute("ListRegion",regionService.getRegion());
        int tsisy=0;
        return "FormRespRegion";
    }
}
