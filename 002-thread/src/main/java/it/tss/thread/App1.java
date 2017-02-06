/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) {

        System.out.println("Program start....." + System.currentTimeMillis());

        for (int i = 0; i < 10; i++) {
            //System.out.println("---" + i);
            new Thread(App1::dowork)
                    .start();
        }
        
    }

    public static void dowork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("--- working..." + System.currentTimeMillis());
    }
}
