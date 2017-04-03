/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.flussi.boundary;

import it.tss.bilancino.business.flussi.entity.Flusso;
import it.tss.bilancino.business.flussi.entity.FlussoPeriodico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/*
curl -i -X POST -H "Content-Type: application/json" -d '{"importo":"200.00"}' http://localhost:8080/bilancino/resources/flussiPeriodici

*/

/**
 *
 * @author tss
 */
@Stateless
@Path("flussiperiodici")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class FlussoPeriodicoResources {

  @Inject
  FlussoPeriodicoManager fm;

  @Inject
  Logger logger;
  
  @GET
  public List<FlussoPeriodico> all() {
    return fm.findAll();
  }

  @POST
  @Path("periodici")
  public Response createPeriodico(FlussoPeriodico f) {
    fm.save(f);
    return Response.ok().build();
  }
  
  @POST  
  public Response create(FlussoPeriodico f) {
    fm.save(f);
    return Response.ok().build();
  }

  @PUT
  @Path("{id}")
  public Response save(@PathParam("id") Long id, FlussoPeriodico f) {
    fm.save(f);
    return Response.ok().build();
  }

  @DELETE
  @Path("{id}")
  public Response delete(@PathParam("id") Long id) {
    fm.remove(id);
    return Response.ok().build();
  }
}
