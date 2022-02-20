/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Administrateur;
import com.cloudproject.backoffice.service.AdministrateurService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author samko
 */
@Controller
public class LogoutController {
    private AdministrateurService adminServ;

    @Autowired
    public void setAdminServ(AdministrateurService adminServ) {
        this.adminServ = adminServ;
    }

    @RequestMapping(value = "/Logout")
    public String FormLogin(Map<String, Object> modelMap, HttpServletRequest request)
    {
        HttpSession sess = request.getSession();
        sess.invalidate();
        
        modelMap.put("Administrateur",new Administrateur());
        
        return "index";
    }
}
