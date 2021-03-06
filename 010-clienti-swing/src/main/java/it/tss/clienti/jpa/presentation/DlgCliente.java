/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.clienti.jpa.presentation;

import it.tss.clienti.jpa.service.ClienteManager;
import it.tss.clienti.jpa.entity.Cliente;

/**
 *
 * @author tss
 */
public class DlgCliente extends javax.swing.JDialog {

    private final Cliente cliente;


    public DlgCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        txtRagSoc.setText(cliente.getRagioneSociale());
        txtInd.setText(cliente.getIndirizzo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRagSoc = new javax.swing.JTextField();
        txtInd = new javax.swing.JTextField();
        cmdSalva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserire/Modificare i dati del Cliente");

        cmdSalva.setText("Salva");
        cmdSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalvaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ragione Sociale");

        jLabel3.setText("Indirizzo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cmdSalva)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtInd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(txtRagSoc, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(txtRagSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(cmdSalva)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalvaActionPerformed

        cliente.setRagioneSociale(txtRagSoc.getText());
        cliente.setIndirizzo(txtInd.getText());
        
        ClienteManager.save(cliente);
        
        this.dispose();
    }//GEN-LAST:event_cmdSalvaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSalva;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtInd;
    private javax.swing.JTextField txtRagSoc;
    // End of variables declaration//GEN-END:variables
}
