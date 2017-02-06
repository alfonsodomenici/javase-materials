/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa.service;

import it.tss.clienti.jpa.MainFx;
import it.tss.clienti.jpa.entity.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class ClienteManager {

    private static EntityManager getEm() {
        return MainFx.getEm();
    }

    public static Cliente save(Cliente cli) {
        getEm().getTransaction().begin();

        Cliente saved = getEm().merge(cli);

        getEm().getTransaction().commit();

        return saved;
    }

    public static List<Cliente> findAll() {
        return getEm()
                .createNamedQuery("Cliente.all")
                .getResultList();
    }

    public static Cliente find(Long cliente_id) {
        return getEm().find(Cliente.class, cliente_id);
    }

    static void remove(Long id) {
        Cliente finded = find(id);
        getEm().getTransaction().begin();
        getEm().remove(finded);
        getEm().getTransaction().commit();
    }
}
