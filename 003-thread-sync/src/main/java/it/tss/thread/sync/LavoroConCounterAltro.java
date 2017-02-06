/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class LavoroConCounterAltro implements Runnable {
    
    private Counter counter;

    public LavoroConCounterAltro(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                counter.decrement();
            } catch (InterruptedException ex) {
                Logger.getLogger(LavoroConCounterAltro.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Thread.currentThread().getId()
                    + " -- decr -- " + counter.value());

        }
    }
}
