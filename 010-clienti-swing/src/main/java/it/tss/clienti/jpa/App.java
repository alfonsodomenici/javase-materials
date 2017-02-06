/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        creaCliente("Carrefour", em);

        creaProdotti(em);

        //creaOrdine(em);

        creaOrdineCarrefour(em);
        
        List<Cliente> clienti = em
                .createNamedQuery("Cliente.findByName", Cliente.class)
                .setParameter("ragsoc", "Carrefour")
                .getResultList();

        if (clienti.isEmpty()) {
            System.out.println("Nessun cliente trovato");
        }

        for (Cliente cliente : clienti) {
            System.out.println(cliente);
        }
    }

    private static void creaCliente(String ragsoc, EntityManager em) {
        Cliente cli = new Cliente(ragsoc);
        cli.setIndirizzo("via roma, 1 Torino");

        em.getTransaction().begin();

        em.persist(cli);

        em.getTransaction().commit();
    }

    private static void creaOrdine(EntityManager em) {
        Cliente c = new Cliente("CIAC");

        Ordine o = new Ordine();
        o.setNumero("A001");
        o.setDescrizione("Ordine di prova");
        o.setCliente(c);

        em.getTransaction().begin();

        em.persist(o);

        em.getTransaction().commit();
    }

    private static void creaOrdineCarrefour(EntityManager em) {

        Cliente cli = em.find(Cliente.class, 1l);

        Ordine o = new Ordine();
        o.setNumero("A001");
        o.setDescrizione("Ordine di prova");
        o.setCliente(cli);

        Prodotto pCoca = em.find(Prodotto.class, 2l);
        Prodotto pBarb = em.find(Prodotto.class, 1l);
        
        o.addDettaglio(new DettaglioOrdine(o, pCoca, 10));
        o.addDettaglio(new DettaglioOrdine(o, pBarb, 1000));
        
        em.getTransaction().begin();

        em.persist(o);

        em.getTransaction().commit();
    }

    private static void creaProdotti(EntityManager em) {

        Prodotto p1 = new Prodotto();
        p1.setNome("CocaCola");
        p1.setPrezzo(5);

        Prodotto p2 = new Prodotto();
        p2.setNome("Barbera");
        p2.setPrezzo(10);

        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);

        em.getTransaction().commit();

    }
}
