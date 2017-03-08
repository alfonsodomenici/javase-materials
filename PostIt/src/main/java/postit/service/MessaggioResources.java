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
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import postit.entity.Messaggio;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("messaggi")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MessaggioResources {

  @Inject
  MessaggioManager messaggioManager;

  @Inject
  UtenteManager utenteManager;

  @GET
  public List<Messaggio> all() {
    return messaggioManager.findAll();
  }

  @GET
  @Path("{id}")
  public Messaggio byId(@PathParam("id") Long id) {
    return messaggioManager.findById(id);
  }

  @GET
  @Path("user/{id}")
  public List<Messaggio> byUser(@PathParam("id") Long id) {
    return messaggioManager.findByUser(id);
  }

  @POST
  public void create(
      @FormParam("titolo") String titolo,
      @FormParam("contenuto") String contenuto,
      @HeaderParam("user_id") Long user_id) {

    Messaggio p = new Messaggio(titolo, contenuto, utenteManager.findById(user_id));
    messaggioManager.save(p);
  }

}
