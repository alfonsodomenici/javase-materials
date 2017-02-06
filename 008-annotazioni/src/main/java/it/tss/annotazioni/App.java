/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.annotazioni;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> clazz = Class.forName("it.tss.annotazioni.Prova");
        //Object oo = clazz.newInstance();

        Annotation[] annotations = clazz.getAnnotations();

        if (annotations.length == 0) {
            System.out.println(clazz.getName() + " non ha annotazioni!!");
        }

        for (int i = 0; i < annotations.length; i++) {
            Annotation annotation = annotations[i];
            System.out.println(annotation.getClass());
        }

        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getAnnotation(MiaAnnotazione.class) != null) {
                MiaAnnotazione annotation = field.getAnnotation(MiaAnnotazione.class);
                System.out.println("Il campo " + field + " è annotato con: " + annotation  );
            }
        }
    }
}
