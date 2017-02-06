/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author tss
 */
public class App3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Program start....." + System.currentTimeMillis());
        
        Callable<String> messageProvider = App3::getMessage;
        List<Future<String>> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Future<String> result = pool.submit(messageProvider);
            results.add(result);
        }

        System.out.println("end for");
        
        for (Future<String> result : results) {
            String r = result.get();
            System.out.println(r);
        }
        
        pool.shutdown();
    }

    public static String getMessage() throws InterruptedException {
        Thread.sleep(2000);
        return "--message " + System.currentTimeMillis();

    }
}
