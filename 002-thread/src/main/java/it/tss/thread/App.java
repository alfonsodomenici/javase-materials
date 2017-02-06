/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        
        Thread th1 = new Thread(App::dowork);
        
        Thread th2 = new Thread(App::dowork1);
        th1.start();
        th2.start();
        
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++Il programma treminerà....");

    }

    public static void dowork() {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            System.out.println("work in progress..." + System.currentTimeMillis());
        }
    }
    
    public static void dowork1() {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            System.out.println("----------------------------work1 in progress..." + System.currentTimeMillis());
        }
    }
    
}
