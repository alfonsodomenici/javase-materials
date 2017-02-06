/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread.sync;

/**
 *
 * @author tss
 */
public class App1 {
    
    public static void main(String[] args) throws InterruptedException {
        
        Counter c = new Counter();
        
        Thread th1 = new Thread(new LavoroConCounter(c));
        th1.start();
        
        Thread th2 = new Thread(new LavoroConCounterAltro(c));
        th2.start();
        
        th1.join();
        th2.join();
        
        System.out.println("valore in main: " + c.value());
    }
}
