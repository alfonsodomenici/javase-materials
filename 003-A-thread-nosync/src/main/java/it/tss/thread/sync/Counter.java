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

    public  void increment() throws InterruptedException {
        Thread.sleep(1000);
        value++;
    }

    public  void decrement() throws InterruptedException {
        value--;
        Thread.sleep(1000);
    }

    public int value() {
        return value;
    }
}
