 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Region;
import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.SignalementRegionService;
import com.cloudproject.backoffice.service.SignalementService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author samko
 */
@Controller
public class InsertSignalementRegion {
    SignalementRegionService signServ;
    SignalementService signalementService;
    TypeService typeService;
    StatusService statusService;
    RegionService regServ;

    @Autowired
    public void setRegServ(RegionService regServ) {
        this.regServ = regServ;
    }

    @Autowired
    public void setSignalementService(SignalementService signalementService) {
        this.signalementService = signalementService;
    }

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setSignServ(SignalementRegionService signServ) {
        this.signServ = signServ;
    }

    @RequestMapping(value ="/insertSign", method = RequestMethod.POST)
    public String insertSign(Map<String, Object> modelMap, HttpServletRequest request) throws ParseException{
        
        String idSignalement=request.getParameter("IdSignalement");
        String NomRegion=request.getParameter("NomRegion");
        
        List<Region> listReg=regServ.getRegionNom(NomRegion);
        Region retourRegion=listReg.get(0);
        
        System.out.println(idSignalement);
        System.out.println(NomRegion);
        System.out.println(retourRegion.getIdRegion());
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String strDate = dateFormat.format(date);  
        
        //Date finalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
        Date finalDate = new Date();
        finalDate=dateFormat.parse(strDate);
        
        System.out.println(finalDate);
        
        signServ.insertSignalementRegion(Integer.parseInt(idSignalement), retourRegion.getIdRegion(), finalDate);
        
        modelMap.put("ListSign", signalementService.getNonAssigner());
        modelMap.put("ListType", typeService.geType());
        modelMap.put("ListStatus", statusService.getStatus());
        
        return "Assigner";
    }
}
