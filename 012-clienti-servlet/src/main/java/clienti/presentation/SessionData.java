/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@SessionScoped
@Named
public class SessionData implements Serializable {

  private String loggedUser;

  public void setLoggedUser(String loggedUser) {
    this.loggedUser = loggedUser;
  }

  public String getLoggedUser() {
    return loggedUser;
  }

}
