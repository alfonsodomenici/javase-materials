/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("hello")
public class HelloRest {
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String msg(){
    return "hello from REST....";
  }
}
