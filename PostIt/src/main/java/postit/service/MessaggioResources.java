/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
  TokenManager tokenManager;

  @Context
  HttpHeaders httpHeaders;

  @Inject
  MessaggioManager messaggioManager;

  @GET
  @TokenNeeded
  public List<Messaggio> all() {
    return messaggioManager.findAll();
  }

  @GET
  @Path("utente/{id}")
  @TokenNeeded
  public List<Messaggio> byUtente(@PathParam("id") Long id) {
    return messaggioManager.findByUser(id);
  }

  @POST
  @TokenNeeded
  public void create(Messaggio m) {
    m.setUtente(tokenManager.getCurrentUser());
    messaggioManager.save(m);
  }

  @PUT
  @Path("{id}")
  @TokenNeeded
  public void update(@PathParam("id") Long id, Messaggio m) {
    if (!Objects.equals(id, m.getId())) {
      System.out.println("generare errore..");
    }
    m.setUtente(tokenManager.getCurrentUser());
    messaggioManager.save(m);
  }

  @DELETE
  @Path("{id}")
  @TokenNeeded
  public void delete(@PathParam("id") Long id) {
    messaggioManager.remove(id);
  }
}
