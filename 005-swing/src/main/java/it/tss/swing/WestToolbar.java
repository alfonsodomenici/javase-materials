/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tss
 */
public class WestToolbar extends JPanel {

    private JButton cmdColor;
    private JButton cmdFont;

    public WestToolbar() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(100, 50));
        cmdColor = new JButton("Color");
        this.add(cmdColor);
        cmdFont = new JButton("Font");
        this.add(cmdFont);
    }

    public JButton getCmdColor() {
        return cmdColor;
    }

    public JButton getCmdFont() {
        return cmdFont;
    }

}
