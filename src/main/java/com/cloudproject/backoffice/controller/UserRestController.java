package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/user/*")
public class UserRestController {
    private UtilisateurService utilisateurService;

    @Autowired
    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/users")
    public void inscription(@RequestBody Utilisateur utilisateur)
    {
        utilisateurService.save(utilisateur);
    }
}
