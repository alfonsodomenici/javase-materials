/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.flussi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@NamedQueries({
  @NamedQuery(name = FlussoPeriodico.FIND_PERIODICHE,
      query = "select e from FlussoPeriodico e order by e.data")
  ,
  @NamedQuery(name = FlussoPeriodico.FIND_ALL_BY_UTENTE,
      query = "select e from FlussoPeriodico e where e.utente= :u "
      + "order by e.data"),})

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class FlussoPeriodico extends Flusso {

  public static final String FIND_PERIODICHE = "FlussoPeriodico.findPeriodiche";
  public static final String FIND_ALL_BY_UTENTE = "FlussoPeriodico.findAllByUtente";

  public static enum Ricorrenza {
    GIORNALIERO, SETTIMANALE, MENSILE, ANNUALE
  };

  public static enum Quando {
    PRIMO_QUARTO, SECONDO_QUARTO, TERZO_QUARTO, QUARTO_QUARTO
  }

  @Enumerated(EnumType.STRING)
  private Ricorrenza ricorrenza = Ricorrenza.MENSILE;
  
  @Enumerated(EnumType.STRING)
  private Quando quando = Quando.SECONDO_QUARTO;

  public Ricorrenza getRicorrenza() {
    return ricorrenza;
  }

  public void setRicorrenza(Ricorrenza ricorrenza) {
    this.ricorrenza = ricorrenza;
  }

  public Quando getQuando() {
    return quando;
  }

  public void setQuando(Quando quando) {
    this.quando = quando;
  }

  
}
