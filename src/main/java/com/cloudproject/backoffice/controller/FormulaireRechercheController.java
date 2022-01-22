package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.StatistiqueCriteriaRegion;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FormulaireRechercheController {
    private TypeService typeService;
    private StatusService statusService;
    private RegionService regionService;

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }


    @RequestMapping("/FormSearch")
    public String initForm(Map<String, Object> modelMap)
    {
        StatistiqueCriteriaRegion stat=new StatistiqueCriteriaRegion();
        modelMap.put("Statistique",stat);
        modelMap.put("ListRegion",regionService.getRegion());
        modelMap.put("ListType",typeService.geType());
        modelMap.put("ListStatus",statusService.getStatus());
        return "FormSearch";
    }
}
