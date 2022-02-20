/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author samko
 */

@Controller
public class FormulaireModifUtilisateur {
    private UtilisateurService userServ;

    @Autowired
    public void setUserServ(UtilisateurService userServ) {
        this.userServ = userServ;
    }
    
    @GetMapping("/modifUtilisateur")
    public String listUtilisateur(Map modelMap, HttpServletRequest request){
        List<Utilisateur> listUtil = userServ.getAllUtilisateur();
        
        HttpSession sess = request.getSession();
        String nomAdmin = (String) sess.getAttribute("nomAdmin");
        
        modelMap.put("nomAdmin", nomAdmin);
        modelMap.put("Utilisateur",new Utilisateur());
        modelMap.put("listUtilisateur", listUtil);
        return "modifUtilisateur";
    }
}
