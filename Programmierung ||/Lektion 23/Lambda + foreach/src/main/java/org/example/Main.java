package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        // Example 2: 30% for every product
        List<Double> articlePrices = Arrays.asList(10.0,15.0,20.0);
        articlePrices.forEach(price -> System.out.println(price * 0.7));
        // eine veränderbare Liste
        List<String> bBrothers = Arrays.asList("Burt", "Bronski", "Peter");
        // eine unveränderbare Liste → Kriegen wir exception
        List<String> bBrothers2 = List.of("Burt", "Bronski", "Peter");

        ////////////////////// anonyme Klasse + stream  short version//////////////////////
        // new Consumer<String //
        bBrothers.stream().forEach(name -> System.out.println(name));
        /*
        ////////////////////// anonyme Klasse + stream //////////////////////
        bBrothers.stream().forEach(new Consumer<String>() { // new Consumer<String> //
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
        // Die Iteration ist intern
         */
        //////////////////////////// foreach Schleife ///////////////////////
        /*
        for (String name : bBrothers) {
            System.out.println(name);
        }
         */
        /////////////////// Wir vermeiden die Operators:  < <= with foreach Schleife/////////////////
        /*
        for (int i = 0; i < bBrothers.size(); i++)
        {
            System.out.println(bBrothers.get(i));
        }
         */

        //Anonyme Klasse + Lambda
        System.out.println("Anonyme Klasse + Lambda:");
        int zahlZumTesten = 633910099;
        Runnable r = () -> {
            boolean isPrimzahl;
            if(zahlZumTesten < 2)
            {
                isPrimzahl = false;
            }
            else
            {
                isPrimzahl = true;
            }
            for (int divisor = 2; divisor < zahlZumTesten; divisor++)
            {
                if(zahlZumTesten % divisor == 0)
                {
                    isPrimzahl = false;
                    break;
                }
            }
            System.out.println(zahlZumTesten + " ist " + (isPrimzahl ? "eine " : "keine ") + "Primzahl.");
        };
        Thread t = new Thread(r);
        t.start();
    }
}