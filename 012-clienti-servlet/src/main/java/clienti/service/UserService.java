/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class UserService {

  @PersistenceContext()
  EntityManager em;

  @Inject
  UserDb db;

  public boolean login(String usr, String pwd) {
    return db.find(usr, pwd);
  }

}
