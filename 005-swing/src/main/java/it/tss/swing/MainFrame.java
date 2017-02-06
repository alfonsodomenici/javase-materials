/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tss
 */
public class MainFrame extends JFrame {

    private JLabel welcome;
    private JButton cmd;
    private JButton tbFile;
    private JButton tbEdit;
    private WestToolbar westToolbar;

    public MainFrame(String titolo) throws HeadlessException {
        super(titolo);
        initGrafica();
    }

    private void initGrafica() {
        this.setSize(500, 200);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System.out.println(this.getContentPane());
        this.getContentPane().setLayout(new BorderLayout());
        //label
        welcome = new JLabel("welcome in swing ....");
        welcome.setFont(new Font("Monospaced", Font.BOLD, 32));
        this.getContentPane().add(welcome, BorderLayout.SOUTH);

        //bottone
        cmd = new JButton("Invia");
        //cmd.setPreferredSize(new Dimension(400, 100));
        this.getContentPane().add(cmd);

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inviaClick(e);
            }

        });

        //toolbar north
        tbFile = new JButton("File");
        tbEdit = new JButton("Edit");
        JPanel pToolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pToolbar.add(tbFile);
        pToolbar.add(tbEdit);
        this.getContentPane().add(pToolbar, BorderLayout.NORTH);

        //toolbar west
        westToolbar = new WestToolbar();
        this.getContentPane().add(westToolbar, BorderLayout.WEST);
        westToolbar.getCmdColor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.setForeground(Color.blue);
            }
        });
    }

    private void inviaClick(ActionEvent e) {
        
        this.welcome.setForeground(this.welcome.getForeground()== Color.RED ?  
                Color.GREEN : Color.RED);
    }

    class AscoltaInvio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(rootPane, "CLICK::::");
        }

    }

}
