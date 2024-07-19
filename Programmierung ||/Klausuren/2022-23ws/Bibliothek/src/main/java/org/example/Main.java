package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Artikel artikel1 = new Rätselspiel("Spiel1", 1000, 500, true);
        Artikel artikel2 = new Raetselbuch("Buch1", 1500, 700, 200, true);
        Artikel artikel3 = new Rätselspiel("Spiel2", 2000, 800, false);
        List<Artikel> artikels = Arrays.asList(artikel1, artikel2, artikel3);

        List<Artikel> result = Artikel.filterEinmalSpielbar(artikels);

        result.forEach(artikel -> System.out.println(artikel.name));
    }
}