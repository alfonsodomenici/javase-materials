/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.factories;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class GenericConfigurationFactory {

    public static Configuration create() {

        try {
            
            Class<?> clazz = Class.forName("it.tss.factories.PropertyConfiguration");
            return (Configuration) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Impossibile creare l'oggetto!! " + ex.getMessage());
        }
    }
}
