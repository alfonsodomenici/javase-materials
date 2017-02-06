/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.annotazioni;


public class Prova {

    public Prova() {
    }

    
    public Prova(String field) {
        this.nome = field;
    }
    
    
    @MiaAnnotazione(tipo = "Ciao")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Prova{" + "field=" + nome + '}';
    }
    
    
}
