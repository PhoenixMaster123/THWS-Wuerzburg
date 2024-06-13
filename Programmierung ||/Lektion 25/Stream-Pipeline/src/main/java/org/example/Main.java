package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BBruder> bBrothers = List.of(
                new BBruder("Burt", 238, 311).add("The Dow of Master Ken: Vol. 1", "The TB12 Method"),
                new BBruder("Bronski", 200, 274).add("Das Buch der fünf Ringe",
                        "Shaolin - Du musst nicht kämpfen, um zu siegen!"),
                new BBruder("Bruno", 236, 328).add("Tao des Jeet Kune Do"));

        bBrothers.stream()
                .filter(b ->
                {
                    System.out.println("filter: " + b);
                    return b.kampfSportBuecher.size()>=2;
                })
                .map(b ->
                {
                    System.out.println("map: " + b);
                    return b.name;
                })
                .forEach(n -> System.out.println("forEach: " + n));

        //Ausgabe: -> for the first person go with every function and after that go to the next person
        /* filter: Name: Burt, Bankdrücken: 238kg, Kniebeugen 311kg  // filter
           map: Name: Burt, Bankdrücken: 238kg, Kniebeugen 311kg    // map
           forEach: Burt                                           // forEach
           filter: Name: Bronski, Bankdrücken: 200kg, Kniebeugen 274kg
           map: Name: Bronski, Bankdrücken: 200kg, Kniebeugen 274kg
           forEach: Bronski
           filter: Name: Bruno, Bankdrücken: 236kg, Kniebeugen 328kg
         */

        List<String> phoneBook = List.of("Albrecht", "Bauer", "Clemens", "Arndt", "Beck", "Christ",
                "Ackermann", "Berger", "Claus", "Adam", "Becker", "Conrad");

        // Its better if first we use filter and then map
        phoneBook.stream()
                .map(n -> {
                    System.out.println("map: " + n);
                    return n.toUpperCase();
                })
                .filter(n -> {
                    System.out.println("filter: " + n);
                    return n.startsWith("A");
                })
                .forEach(n -> {
                    System.out.println("forEach: " + n);
                });

        System.out.println();

        // better Version
        phoneBook.stream()
                .filter(n -> {
                    System.out.println("filter: " + n);
                    return n.startsWith("A");
                })
                .map(n -> {
                    System.out.println("map: " + n);
                    return n.toUpperCase();
                })
                .sorted() // we also sort them (alphabetic)
                .forEach(n -> {
                    System.out.println("forEach: " + n);
                });



    }
}