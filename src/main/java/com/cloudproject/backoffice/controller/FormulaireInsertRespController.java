package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.ResponsableRegion;
import com.cloudproject.backoffice.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FormulaireInsertRespController {
    private RegionServiceImpl regionService;
    @Autowired
    public void setRegionService(RegionServiceImpl regionService) {
        this.regionService = regionService;
    }


    @RequestMapping("/formRespRegion")
    public String initForm(Map<String, Object> modelMap, HttpServletRequest request)
    {
        ResponsableRegion responsableRegion=new ResponsableRegion();
        
        HttpSession sess = request.getSession();
        String nomAdmin = (String) sess.getAttribute("nomAdmin");
        
        modelMap.put("nomAdmin", nomAdmin);
        modelMap.put("ResponsableRegion",responsableRegion);
        modelMap.put("ListRegion",regionService.getRegion());
        return "FormRespRegion";
    }
}
