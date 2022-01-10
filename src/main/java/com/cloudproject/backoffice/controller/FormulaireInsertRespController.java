package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class FormulaireInsertRespController {
    private RegionServiceImpl regionService;
    @Autowired
    public void setRegionService(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }


    @RequestMapping("/formRespRegion")
    public String initForm(Map<String, Object> modelMap)
    {
        ResponsableRegion responsableRegion=new ResponsableRegion();
        modelMap.put("ResponsableRegion",responsableRegion);
        modelMap.put("ListRegion",regionService.getRegion());
        return "FormRespRegion";
    }
}
