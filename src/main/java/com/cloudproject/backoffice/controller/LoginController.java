package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    private UtilisateurService utilisateurService;

    @Autowired
    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping(value = "/formInsert")
    public String FormLogin(Map<String, Object> modelMap)
    {
        modelMap.put("Utilisateur",new Utilisateur());
        return "FormLogin";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String TraitLogin(@ModelAttribute("Utilisateur") @Validated Utilisateur utilisateur,
                             BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("Utilisateur",new Utilisateur());
            return "FormLogin";
        }
        else
        {
            Utilisateur util=utilisateurService.getUtilisateur(request.getParameter("Email"),request.getParameter("MotDePasse"));

            if(util.getIdUtilisateur()==null)
            {
                model.addAttribute("erreur","Verifier votre identifiant et votre mot de passe");
                model.addAttribute("Utilisateur",new Utilisateur());
                return "FormLogin";
            }
            else
            {
                HttpSession sess=request.getSession();
                sess.setAttribute("IdUtilisateur",util.getIdUtilisateur());
                return "Accueil";
            }
        }
    }
}
