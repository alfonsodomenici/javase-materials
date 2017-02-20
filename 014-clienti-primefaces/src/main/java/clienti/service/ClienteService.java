/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.service;

import clienti.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class ClienteService {

    @PersistenceContext
    EntityManager em;

    /**
     *
     * @return
     */
    public List<Cliente> findAll() {
        return em.createNamedQuery("Cliente.all")
                .getResultList();
    }

    /**
     * Crea un nuovo cliente su db con i dati passati come parametri
     *
     * @param ragsoc
     * @param ind
     * @return
     */
    public Cliente save(String ragsoc, String ind) {
        Cliente cliente = new Cliente(ragsoc);
        cliente.setIndirizzo(ind);
        return save(cliente);
    }

    /**
     * Salva il cliente su db passato come parametro
     *
     * @param tosave
     * @return
     */
    public Cliente save(Cliente tosave) {
        System.out.println(tosave);
        return em.merge(tosave);
    }

    /**
     *
     * @param id
     */
    public void delete(Long id) {
        Cliente finded = em.find(Cliente.class, id);
        em.remove(finded);
    }

    public Cliente find(Long id) {
        return em.find(Cliente.class, id);
    }

}
