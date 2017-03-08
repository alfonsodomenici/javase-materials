/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("utenti")
@Produces({MediaType.APPLICATION_JSON})
public class UtenteResources {

  @Inject
  UtenteManager utenteManager;

  @GET
  public List<Utente> all() {
    return utenteManager.findAll();
  }

  @GET
  @Path("{id}")
  public Utente find(@PathParam("id") Long id) {
    return utenteManager.findById(id);
  }

  @DELETE
  @Path("{id}")
  public void delete(@PathParam("id") Long id) {
    utenteManager.remove(id);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void create(Utente utente) {
    utenteManager.save(utente);
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void create(@FormParam("usr") String usr,
      @FormParam("pwd") String pwd,
      @FormParam("email") String email) {

    Utente u = new Utente(usr, pwd, email);
    utenteManager.save(u);
  }
}
