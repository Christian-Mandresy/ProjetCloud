/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Administrateur;
import java.util.List;

/**
 *
 * @author samko
 */
public interface AdministrateurDao {

    void InsertAdmin(String NomAdmin, String PrenomAdmin, String Email, String MotDePasse);

    void UpdateAdmin(int idAdmin, String NomAdmin, String PrenomAdmin, String Email, String MotDePasse);

    Administrateur getAdmin(String email, String mdp);

    List getAllAdmin();
    
}
