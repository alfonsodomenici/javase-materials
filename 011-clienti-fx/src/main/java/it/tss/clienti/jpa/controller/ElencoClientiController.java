/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa.controller;

import it.tss.clienti.jpa.service.ClienteManager;
import it.tss.clienti.jpa.entity.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author tss
 */
public class ElencoClientiController implements Initializable {

     @FXML
    private TableView<Cliente> tblClienti;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn ragSoc;
    @FXML
    private TableColumn ind;
    
    @FXML
    private MenuItem mnuClose;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(
                new PropertyValueFactory<Cliente,Long>("id"));
        ragSoc.setCellValueFactory(
                new PropertyValueFactory<Cliente,String>("ragioneSociale"));
        ind.setCellValueFactory(
                new PropertyValueFactory<Cliente,Long>("indirizzo"));
        ObservableList<Cliente> elencoClienti = FXCollections.observableArrayList(ClienteManager.findAll());
        tblClienti.setItems(elencoClienti);
    }     
    
    @FXML
    public void handleClose(Event t) {
        System.exit(0);
    }
    
}
