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
import postit.entity.Utente;

/**
 *
 * @author alfonso
 */
@Stateless
public class UtenteManager {
    
    @PersistenceContext
    EntityManager em;
    
    public Utente save(Utente tosave){
        return em.merge(tosave);
    }
    
    public void remove(Utente toremove){
        Utente find = em.find(Utente.class,toremove.getId());
        em.remove(find);
    }
    
    public List<Utente> findAll(){
        return em.createNamedQuery(Utente.FIND_ALL)
                .getResultList();
    } 
    
    public Utente findByUserAndPwd(String usr, String pwd){
        return em.createNamedQuery(Utente.FIND_BY_USER_PWD,Utente.class)
                .setParameter("usr", usr)
                .setParameter("pwd", pwd)
                .getSingleResult();
    }
    
    public Utente getLogged(){
        return em.find(Utente.class, 1l);     
    }
}
