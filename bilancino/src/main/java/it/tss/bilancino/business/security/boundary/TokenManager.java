/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.security.boundary;

import it.tss.bilancino.business.security.entity.Utente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author alfonso
 */
@RequestScoped
public class TokenManager {
    
    @Inject
    UtenteManager utenteManager;
    
    private Utente utente;

    public boolean validateToken(String token){
        boolean result = false;
        try{
            Long id = Long.parseLong(token);
            utente = utenteManager.findById(id);
            result=true;
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return result;
    }

    public Utente getCurrentUser() {
        return utente;
    }
    
}
