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
public class App {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        counter.increment();
                        System.out.println(Thread.currentThread().getId()
                                + " -- incr -- " + counter.value());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        th1.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        counter.decrement();
                        System.out.println(Thread.currentThread().getId()
                                + " -- decr -- " + counter.value());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        th2.start();

        th1.join();
        th2.join();

        System.out.println("value in main: " + counter.value());

    }

}
