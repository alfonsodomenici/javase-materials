/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.factories;

import java.util.Map;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        
        
        Configuration conf = GenericConfigurationFactory.create();
        
        Work work = new Work();
        work.dowork(conf);
        
    }
}
