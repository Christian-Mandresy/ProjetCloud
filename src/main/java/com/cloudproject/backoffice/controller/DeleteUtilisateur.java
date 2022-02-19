/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Signalement;
import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.SignalementService;
import com.cloudproject.backoffice.service.UtilisateurService;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class DeleteUtilisateur {
    private UtilisateurService userServ;
    private SignalementService signServ;

    @Autowired
    public void setUserServ(UtilisateurService userServ) {
        this.userServ = userServ;
    }

    @Autowired
    public void setSignServ(SignalementService signServ) {
        this.signServ = signServ;
    }
    
    @RequestMapping(value = "/DeleteUtilisateur", method = RequestMethod.POST)
    public String deleteRespReg(@ModelAttribute("Utilisateur") @Validated Utilisateur Utilisateur,
            BindingResult bindingResult, Model modelMap, HttpServletRequest request) {
        
        List<Signalement> allSign = signServ.getAllSign();
        for(int i=0;i<allSign.size();i++){
            if(allSign.get(i).getIdUtilisateur()==Integer.parseInt(request.getParameter("IdUtilisateur"))){
                signServ.updateSignalement(allSign.get(i).getIdSignalement(), null, allSign.get(i).getIdType(), allSign.get(i).getIdStatus(), allSign.get(i).getDescriptionSignalement(), allSign.get(i).getLongitude(), allSign.get(i).getLatitude(), allSign.get(i).getDateHeureSignalement());
            }
        }
        
        userServ.DeleteUtilisateur(Integer.parseInt(request.getParameter("IdUtilisateur")));
        
        List<Utilisateur> listUtil = userServ.getAllUtilisateur();
        
        modelMap.addAttribute("Utilisateur",new Utilisateur());
        modelMap.addAttribute("listUtilisateur", listUtil);
        return "modifUtilisateur";
    }
}
