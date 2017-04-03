/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bilancino.business.logging.boundary;

import it.tss.bilancino.business.flussi.boundary.ChangeEvent;
import it.tss.bilancino.business.flussi.entity.Flusso;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

/**
 *
 * @author tss
 */
public class FlussiLogging {
  
  @Inject
  Logger logger;
  
  public void logCreation(@Observes(during = TransactionPhase.AFTER_SUCCESS)
      @ChangeEvent(ChangeEvent.Type.CREATION) Flusso f){
    logger.info("creato il flusso: " + f);
  }
  
  public void logUpdates(@Observes(during = TransactionPhase.AFTER_SUCCESS)
      @ChangeEvent(ChangeEvent.Type.UPDATE) Flusso f){
    logger.info("aggiornato il flusso: " + f);
  }
  
  public void logDeletes(@Observes(during = TransactionPhase.AFTER_SUCCESS)
      @ChangeEvent(ChangeEvent.Type.DELETE) Flusso f){
    logger.log(Level.INFO, "cancellato il flusso: {0}", f);
  }
}
