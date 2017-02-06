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
public class Counter {

    private int value = 0;

    public synchronized void increment() throws InterruptedException {
        Thread.sleep(1000);
        value++;
    }

    public synchronized void decrement() throws InterruptedException {
        Thread.sleep(1000);
        value--;  
    }

    public  int value() {
        return value;
    }
}
