package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.StatistiqueCriteriaRegion;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.StatGlobaleService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FormulaireStatistique {
    private TypeService typeService;
    private StatusService statusService;
    private RegionService regionService;
    private StatGlobaleService statGlobaleService;

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

    @Autowired
    public void setStatGlobaleService(StatGlobaleService statGlobaleService) {
        this.statGlobaleService = statGlobaleService;
    }

    @RequestMapping("/FormStatistique")
    public String initForm(Map<String, Object> modelMap)
    {
        StatistiqueCriteriaRegion stat=new StatistiqueCriteriaRegion();
        modelMap.put("Statistique",stat);
        modelMap.put("ListRegion",regionService.getRegion());
        modelMap.put("ListType",typeService.geType());
        modelMap.put("ListStatus",statusService.getStatus());
        modelMap.put("ListStatRegion",statGlobaleService.getStatRegion());
        modelMap.put("ListStatType",statGlobaleService.getStatType());
        modelMap.put("ListStatStatus",statGlobaleService.getStatStatus());
        return "FormStat";
    }
}
