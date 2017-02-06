/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App2 {

    public static void main(String[] args) {

        System.out.println("Program start....." + System.currentTimeMillis());

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            pool.submit(App2::dowork);
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
