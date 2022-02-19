/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.Administrateur;
import java.util.List;

/**
 *
 * @author samko
 */
public interface AdministrateurService {

    Administrateur getAdmin(String email, String mdp);

    List getAllAdmin();

    void insertAdmin(String NomAdmin, String PrenomAdmin, String Email, String MotDePasse);

    void updateAdmin(int idAdmin, String NomAdmin, String PrenomAdmin, String Email, String MotDePasse);
    
}
