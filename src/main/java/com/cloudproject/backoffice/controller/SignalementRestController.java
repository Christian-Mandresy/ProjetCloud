package com.cloudproject.backoffice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.cloudproject.backoffice.model.Signalement;
import com.cloudproject.backoffice.model.StatistiqueCriteriaRegion;
import com.cloudproject.backoffice.service.SignalementService;
import com.cloudproject.backoffice.service.StatistiqueCriteriaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/signalement/*")
public class SignalementRestController {
    private SignalementService signalementService;
    private StatistiqueCriteriaRegionService statistiqueCriteriaRegionService;

    @Autowired
    public void setSignalementService(SignalementService signalementService) {
        this.signalementService = signalementService;
    }

    @Autowired
    public void setStatService(StatistiqueCriteriaRegionService statService) {
        this.statistiqueCriteriaRegionService = statService;
    }

    @GetMapping(value = "/signalements")
    public ResponseEntity<Collection<Signalement>> getAllSign() {
        Collection<Signalement> users = signalementService.getAllSign();
        return new ResponseEntity<Collection<Signalement>>(users, HttpStatus.FOUND);
        }

    @GetMapping(value = "/signalements/{IdRegion}")
    public ResponseEntity<Collection<Signalement>> getSignRegion(@PathVariable("IdRegion") String Id) {
        int IdRegion=Integer.parseInt(Id.substring(11));
        Collection<Signalement> signal = signalementService.getSignRegion(IdRegion);
        return new ResponseEntity<Collection<Signalement>>(signal, HttpStatus.FOUND);
    }

    @GetMapping(value = "/signalements/user/{IdUser}")
    public ResponseEntity<Collection<Signalement>> getSignUser(@PathVariable("IdUser") String Id) {
        int IdRegion=Integer.parseInt(Id);
        Collection<Signalement> signal = signalementService.getSignUser(IdRegion);
        return new ResponseEntity<Collection<Signalement>>(signal, HttpStatus.FOUND);
    }

    @GetMapping(value = "/signalements/filtre")
    public ResponseEntity<Collection<StatistiqueCriteriaRegion>> RechercheAvance(@RequestParam Map<String,String> allParams) {

        int type=Integer.parseInt(allParams.get("type"));
        int etat=Integer.parseInt(allParams.get("etat"));
        String region=allParams.get("region");
        Date datedeb= new Date();
        Date dateFin=new Date();
        try {
            datedeb =new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("dateDeb"));
            dateFin= new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("dateFin"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Parameters are " + allParams.entrySet());
        Collection<StatistiqueCriteriaRegion> listRecherche=statistiqueCriteriaRegionService.find(type,etat,region,datedeb,dateFin);
        return new ResponseEntity<Collection<StatistiqueCriteriaRegion>>(listRecherche,HttpStatus.FOUND);
    }

}
