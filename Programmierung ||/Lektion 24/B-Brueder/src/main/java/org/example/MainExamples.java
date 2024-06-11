package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

public class MainExamples {
    public static void main(String[] args) {
       /* List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311),
                new BBruder("Bronski", 200, 274),
                new BBruder("Bruno", 236, 328));
        */
        List<BBruder> bBrothers = List.of(
                new BBruder("Burt", 238, 311).add("The Dow of Master Ken: Vol. 1"),
                new BBruder("Bronski", 200, 274)
                        .add("Das Buch der fünf Ringe", "Shaolin - Du musst nicht kämpfen, um zu siegen!"),
                new BBruder("Bruno", 236, 328).add("Tao des Jeet Kune Do", "Das Buch der fünf Ringe"));

        // How the Reduce operator is used
        bBrothers.stream()
                .reduce((b1,b2) -> new BBruder(
                        "Bester",
                        b1.bankDrueckenGewicht > b2.bankDrueckenGewicht ? b1.bankDrueckenGewicht : b2.bankDrueckenGewicht,
                        b1.knieBeugenGewicht > b2.knieBeugenGewicht ? b1.knieBeugenGewicht : b2.knieBeugenGewicht))
                .ifPresent(b -> System.out.println(b));

        //////////////////////////////////// Variant 2 ///////////////
        BBruder best = bBrothers.stream()
                .reduce(new BBruder("Bester", 0, 0),
                        (b1, b2) -> new BBruder(
                                "Bester",
                                b1.bankDrueckenGewicht > b2.bankDrueckenGewicht ? b1.bankDrueckenGewicht : b2.bankDrueckenGewicht,
                                b1.knieBeugenGewicht > b2.knieBeugenGewicht ? b1.knieBeugenGewicht : b2.knieBeugenGewicht));
        System.out.println(best);

        System.out.println();
        System.out.println("Average:");
        ///////////////////////////////////////////// How average works ///////////////////////////////////
        bBrothers.stream()
                .mapToDouble(p -> p.bankDrueckenGewicht)
                .average()
                .ifPresent(System.out::println);

        ////////////////////////////////////////////// toMap Funktion //////////////////////////////////////////////
        System.out.println();
        System.out.println("Collect the data from the Brothers and store in a Map:");
        Map<String, BBruder> map = bBrothers.stream().collect(Collectors.toMap(b -> b.name, b -> b));
        System.out.println(map);

        ////////////////////////////////////////////// flatMap Funktion //////////////////////////////////////////////
        System.out.println();
        System.out.println("How to use flatMap:");
        //First Solution -> inefficient:
        List<String> buecher = new ArrayList<>();
        bBrothers.stream().map(b -> b.kampfSportBuecher).forEach(k -> buecher.addAll(k));

        buecher.forEach(System.out::println);
        System.out.println();
        //Second Solution
        bBrothers.stream().flatMap(b -> b.kampfSportBuecher.stream())
                .distinct() // remove doppelt elemente (ohne duplicates)
                .sorted() // sort with natural order (alphabetic)
                .forEach(System.out::println);

        ////////////////////////////////////////////// groupingBy Funktion //////////////////////////////////////////////
        System.out.println();
        System.out.println("How to use groupingBy:");
        //First Solution
        Map<Boolean, List<BBruder>> map2 = bBrothers.stream()
                .collect(Collectors.groupingBy(b -> b.kampfSportBuecher.size() >= 2)); // if the size >= 2 return true/false
        map2.forEach((k,v) -> System.out.println(k ? "Mehr als zwei Bücher gelesen:  " + v // true
                                                   : "Höchstens zwei Bücher gelesen:  " + v)); // false
        System.out.println();
        Map<Integer, List<BBruder>> map3 = bBrothers.stream()
                .collect(Collectors.groupingBy(b -> b.kampfSportBuecher.size())); // we receive digit
        map3.forEach((k,v) -> System.out.println(k + (k == 1 ? " Buch gelesen:  " + v
                                                             : " Bücher gelesen:  ") + v));

    }
}