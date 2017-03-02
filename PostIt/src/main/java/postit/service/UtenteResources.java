/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("users")
public class UtenteResources {
    
    @Inject
    UtenteManager utenteManager;
           
    @GET
    public List<Utente> all(){
        return utenteManager.findAll();
    }
    
    @POST
    public void create(@FormParam("usr") String usr, 
            @FormParam("pwd") String pwd,
            @FormParam("email") String email){
        
        Utente u = new Utente(usr, pwd, email);
        utenteManager.save(u);
    }
}
