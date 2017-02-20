/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.entity.Cliente;
import clienti.service.ClienteService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named
@RequestScoped
public class ClienteBean implements Serializable {

  @Inject
  ClienteService clienteService;

  private List<Cliente> clienti;

  private Cliente cliente;

  @PostConstruct
  public void init() {
    System.out.println("onInit()..");
    this.clienti = clienteService.findAll();
    cliente = new Cliente();
  }

  public List<Cliente> getClienti() {
    return clienti;
  }

  public String onNuovo() {
    cliente = new Cliente();
    return "modificaCliente";
  }

  public void onElimina(Long id) {
    clienteService.delete(id);
    clienti = clienteService.findAll();
  }

  public String onSave() {
    try {
      clienteService.save(cliente);
      clienti = clienteService.findAll();
      return "elencoClienti";
    } catch (EJBException ex) {
      FacesContext.getCurrentInstance()
          .addMessage(null,
              new FacesMessage(
                  FacesMessage.SEVERITY_ERROR,
                  "Si è verificato un errore durante il salvataggio",
                  ""));
    }
    return null;
  }

  public String onModifica(Long id) {
    cliente = clienteService.find(id);
    return "modificaCliente";
  }

  /*
    get e set
   */
  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
