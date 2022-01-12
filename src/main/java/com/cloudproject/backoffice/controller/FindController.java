package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.service.RegionService;
import com.cloudproject.backoffice.service.StatistiqueCriteriaRegionService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class FindController {
    private StatistiqueCriteriaRegionService statistiqueCriteriaRegionService;
    private StatusService statusService;
    private RegionService regionService;
    private TypeService typeService;

    @Autowired
    public void setStatistiqueCriteriaRegionService(StatistiqueCriteriaRegionService statistiqueCriteriaRegionService) {
        this.statistiqueCriteriaRegionService = statistiqueCriteriaRegionService;
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
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping(value = "/find" , method = RequestMethod.POST)
    public String find(Model model, HttpServletRequest request)
    {
        String type=request.getParameter("idType");
        String status=request.getParameter("idStatus");
        int typenum=0;
        int statusnum=0;
        if(type.equals("")==false)
        {
            typenum=Integer.parseInt(type);
        }
        if(status.equals("")==false)
        {
            statusnum=Integer.parseInt(status);
        }

        String region=request.getParameter("idRegion");
        String dateDeb=request.getParameter("DateDeb");
        String dateFin=request.getParameter("DateFin");
        List ListType=typeService.geType();
        List ListStatus=statusService.getStatus();
        List ListRegion=regionService.getRegion();
        Date TdateDeb=new Date();
        Date TdateFin=new Date();
        if(dateDeb.equals("")==true)
        {
            TdateDeb=null;
            TdateFin=null;
        }
        else
        {
            try {
                TdateDeb=new SimpleDateFormat("yyyy-MM-dd").parse(dateDeb);
                TdateFin=new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List Stat=statistiqueCriteriaRegionService.find(typenum,
                statusnum,region,TdateDeb,TdateFin);

        model.addAttribute("ListType",ListType);
        model.addAttribute("ListStatus",ListStatus);
        model.addAttribute("ListRegion",ListRegion);
        model.addAttribute("ListStat",Stat);
        int tsisy =0;
        return "DisplaySearch";
    }
}
