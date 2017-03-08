/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import postit.entity.Messaggio;
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
public class MessaggioManager {
  
    @PersistenceContext
    private EntityManager em;

    public Messaggio save(Messaggio tosave) {
        return em.merge(tosave);
    }

    public void remove(Messaggio toremove) {
        Messaggio find = em.find(Messaggio.class, toremove.getId());
        em.remove(find);
    }

    public List<Messaggio> findAll(){
        return em.createNamedQuery(Messaggio.FIND_ALL)
                .getResultList();
    }
    
    public List<Messaggio> findByUser(Long userId){
        return findByUser(em.find(Utente.class, userId));
    }
    
    public List<Messaggio> findByUser(Utente u){
        return em.createNamedQuery(Messaggio.FIND_BY_USER)
                .setParameter("usr", u)
                .getResultList();
    }

    public Messaggio findById(Long id) {
         return em.find(Messaggio.class, id);
    }
}
