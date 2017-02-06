/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author tss
 */
public class Counter {

    private AtomicInteger value = new AtomicInteger(0);

    public  void increment() throws InterruptedException {
        Thread.sleep(100);
        value.incrementAndGet();
    }

    public  void decrement() throws InterruptedException {
        Thread.sleep(100);
        value.decrementAndGet();
    }

    public  int value() {
        return value.get();
    }
}
