/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author tss
 */
@ApplicationScoped
@Startup
public class UserDb {

  Map<String, String> db = new HashMap<>();

  @PostConstruct
  public void init() {
    db.put("mario", "mario");
    db.put("luca", "luca");
  }

  public boolean find(String usr, String pwd) {

    for (Map.Entry<String, String> entry : db.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      if (key.equals(usr) && value.equals(pwd)) {
        return true;
      }
    }
    return false;
  }
}
