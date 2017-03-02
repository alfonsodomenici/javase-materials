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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import postit.entity.Postit;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("postits")
@Produces({MediaType.APPLICATION_JSON})
public class PostitResources {

    @Inject
    PostitManager postitManager;

    @Inject
    UtenteManager utenteManager;

    @GET
    public List<Postit> all() {
        return postitManager.findAll();
    }

    @GET
    @Path("{id}")
    public Postit byId(@PathParam("id") Long id) {
        return postitManager.findById(id);
    }

    @GET
    @Path("user/{id}")
    public List<Postit> byUser(@PathParam("id") Long id) {
        return postitManager.findByUser(id);
    }

    @POST
    public void create(@FormParam("titolo") String titolo,
            @FormParam("contenuto") String contenuto) {
        Postit p = new Postit(titolo, contenuto, utenteManager.getLogged());
        postitManager.save(p);
    }
    
}
