package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Administrateur;
import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import javax.validation.Valid;

@Controller
public class LoginController {
    private AdministrateurService adminServ;

    @Autowired
    public void setAdminServ(AdministrateurService adminServ) {
        this.adminServ = adminServ;
    }

    @RequestMapping(value = "/")
    public String FormLogin(Map<String, Object> modelMap)
    {
        modelMap.put("Administrateur",new Administrateur());
        return "index";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String TraitLogin(@Valid @ModelAttribute("Administrateur") Administrateur administrateur,
                             BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            return "index";
        }
        else
        {
            Administrateur admin=adminServ.getAdmin(request.getParameter("Email"),request.getParameter("MotDePasse"));

            if(admin.getIdAdmin()==0)
            {
                model.addAttribute("erreur","Verifier votre identifiant et votre mot de passe");
                model.addAttribute("Utilisateur",new Utilisateur());
                return "index";
            }
            else
            {
                HttpSession sess=request.getSession();
                sess.setAttribute("IdAdmin",admin.getIdAdmin());
                sess.setAttribute("nomAdmin",admin.getNomAdmin());
                sess.setAttribute("PrenomAdmin",admin.getPrenomAdmin());
                return "Acceuil";
            }
        }
    }
}
