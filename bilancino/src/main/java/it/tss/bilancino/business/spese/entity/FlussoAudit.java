/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.spese.entity;

import it.tss.bilancino.business.spese.boundary.ChangeEvent;
import it.tss.bilancino.business.spese.entity.Flusso;
import java.util.logging.Logger;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

/**
 *
 * @author tss
 */
public class FlussoAudit {

  @Inject
  Logger logger;

  
  @Inject
  @ChangeEvent(ChangeEvent.Type.CREATION)
  Event<Flusso> create;

  @Inject
  @ChangeEvent(ChangeEvent.Type.UPDATE)
  Event<Flusso> update;
  
  @Inject
  @ChangeEvent(ChangeEvent.Type.DELETE)
  Event<Flusso> delete;

  @PostPersist
  public void onPersist(Flusso f) {
    this.create.fire(f);
  }

  @PostUpdate
  public void onUpdate(Flusso f) {
    this.update.fire(f);
  }

  @PostRemove
  public void onRemove(Flusso f){
    this.delete.fire(f);
  }
}
