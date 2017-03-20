/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import postit.Security;
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
public class UtenteManager {

  @PersistenceContext
  EntityManager em;

  public Utente save(Utente tosave) {
    tosave.setPwd(Security.digestPassword(tosave.getPwd()));
    return em.merge(tosave);
  }

  public void remove(Utente toremove) {
    remove(toremove.getId());
  }

  public void remove(Long id) {
    Utente find = em.find(Utente.class, id);
    em.remove(find);
  }

  public List<Utente> findAll() {
    return em.createNamedQuery(Utente.FIND_ALL)
        .getResultList();
  }

  public Utente findByUserAndPwd(String usr, String pwd) {
    Utente result = null;
    try {
      result = em.createNamedQuery(Utente.FIND_BY_USER_PWD, Utente.class)
          .setParameter("usr", usr)
          .setParameter("pwd", pwd)
          .getSingleResult();
    } catch (NoResultException ex) {
      //ignored
    }
    return result;
  }

  public Utente findById(Long id) {
    return em.find(Utente.class, id);
  }

  public Utente getLogged() {
    return em.find(Utente.class, 1l);
  }
  
  
}
