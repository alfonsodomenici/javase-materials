/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.flussi.boundary;

import it.tss.bilancino.business.flussi.entity.Flusso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class FlussoManager {

  @PersistenceContext
  EntityManager em;

  public Flusso save(Flusso tosave) {
    return em.merge(tosave);
  }

  public void remove(Long id) {
    em.remove(em.getReference(Flusso.class, id));
  }

  public Flusso findById(Long id) {
    return em.find(Flusso.class, id);
  }

  public List<Flusso> findAll() {
    return em.createNamedQuery(Flusso.FIND_ALL).getResultList();
  }
}
