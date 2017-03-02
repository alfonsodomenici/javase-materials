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
import postit.entity.Postit;
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
public class PostitManager {

    @PersistenceContext
    private EntityManager em;

    public Postit save(Postit tosave) {
        return em.merge(tosave);
    }

    public void remove(Postit toremove) {
        Postit find = em.find(Postit.class, toremove.getId());
        em.remove(find);
    }

    public List<Postit> findAll(){
        return em.createNamedQuery(Postit.FIND_ALL)
                .getResultList();
    }
    
    public List<Postit> findByUser(Long id){
        return findByUser(em.find(Utente.class, id));
    }
    
    public List<Postit> findByUser(Utente u){
        return em.createNamedQuery(Postit.FIND_BY_USER)
                .setParameter("usr", u)
                .getResultList();
    }

    public Postit findById(Long id) {
         return em.find(Postit.class, id);
    }
}
