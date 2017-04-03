/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.flussi.boundary;

import it.tss.bilancino.business.flussi.entity.Flusso;
import it.tss.bilancino.business.flussi.entity.FlussoPeriodico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class FlussoPeriodicoManager {

  @PersistenceContext
  EntityManager em;

  public FlussoPeriodico save(FlussoPeriodico tosave) {
    return em.merge(tosave);
  }

  public void remove(Long id) {
    em.remove(em.getReference(FlussoPeriodico.class, id));
  }

  public Flusso findById(Long id) {
    return em.find(FlussoPeriodico.class, id);
  }

  public List<FlussoPeriodico> findAll() {
    return em.createNamedQuery(FlussoPeriodico.FIND_PERIODICHE).getResultList();
  }
}
