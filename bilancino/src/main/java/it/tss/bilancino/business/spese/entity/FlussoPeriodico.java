/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.spese.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author tss
 */
@NamedQueries({
  @NamedQuery(name = FlussoPeriodico.FIND_ALL,
      query = "select e from FlussoPeriodico e order by e.data"),
  @NamedQuery(name = FlussoPeriodico.FIND_ALL_BY_UTENTE,
      query = "select e from FlussoPeriodico e where e.utente= :u "
          + "order by e.data"),
  
})

@Entity
public class FlussoPeriodico extends Flusso {

  public static final String FIND_ALL = "FlussoPeriodico.findAll";
  public static final String FIND_ALL_BY_UTENTE = "FlussoPeriodico.findAllByUtente";
  
  public static enum Ricorrenza {
    GIORNALIERO, SETTIMANALE, MENSILE, ANNUALE
  };

  @Enumerated(EnumType.STRING)
  private Ricorrenza ricorrenza;

  public Ricorrenza getRicorrenza() {
    return ricorrenza;
  }

  public void setRicorrenza(Ricorrenza ricorrenza) {
    this.ricorrenza = ricorrenza;
  }

}
