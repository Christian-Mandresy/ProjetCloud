/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class ModifUtilisateur {
    private UtilisateurService userServ;

    @Autowired
    public void setUserServ(UtilisateurService userServ) {
        this.userServ = userServ;
    }
    
    @RequestMapping(value = "/UpdateUtilisateur", method = RequestMethod.POST)
    public String updateUtilisateur(@ModelAttribute("Utilisateur") @Validated Utilisateur utilisateur,
            BindingResult bindingResult, Model modelMap, HttpServletRequest request) throws ParseException{
        userServ.UpdateUtilisateur(Integer.parseInt(request.getParameter("IdUtilisateur")), request.getParameter("Nom"), request.getParameter("Prenom"), request.getParameter("DateNaissance"), request.getParameter("Email"), request.getParameter("MotDePasse"), request.getParameter("Sexe"), request.getParameter("Contact"));
        
        List<Utilisateur> listUtil = userServ.getAllUtilisateur();
        
        HttpSession sess = request.getSession();
        String nomAdmin = (String) sess.getAttribute("nomAdmin");
        
        modelMap.addAttribute("nomAdmin", nomAdmin);
        modelMap.addAttribute("Utilisateur",new Utilisateur());
        modelMap.addAttribute("listUtilisateur", listUtil);
        return "modifUtilisateur";
    }
}
