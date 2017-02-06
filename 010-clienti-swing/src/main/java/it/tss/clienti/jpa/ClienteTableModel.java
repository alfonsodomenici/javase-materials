/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tss
 */
public class ClienteTableModel extends AbstractTableModel {

    private  List<Cliente> clienti;
    private final String[] columnNames = {"id","Ragione Sociale","Indirizzo"};

    public ClienteTableModel() {
        loadData();
    }

    @Override
    public int getRowCount() {
        return clienti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cli = clienti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cli.getId();
            case 1:
                return cli.getRagioneSociale();
            case 2:
                return cli.getIndirizzo();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void refresh(){
        loadData();
        this.fireTableDataChanged();
    }
    
    private void loadData(){
        clienti = ClienteManager.findAll();
    }
}
