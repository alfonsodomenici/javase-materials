/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import clienti.entity.Ordine;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class OrdineFacade extends AbstractFacade<Ordine> {

  @PersistenceContext(unitName = "pu")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public OrdineFacade() {
    super(Ordine.class);
  }
  
}
