package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Kartendeck
{
    List<Karte> karten;

    public void erzeugeDeck() {
        karten = new ArrayList<>();
        Arrays.stream(Wert.values()).forEach(wert ->
        {
            Arrays.stream(Farbe.values()).forEach(
                    farbe -> {
                        karten.add(new Karte(farbe, wert));
                    }
            );
        });
        System.out.println(karten);
    }
    public void erzeugeDeckMitFlat() {
        karten = Arrays.stream(Wert.values()).flatMap(wert ->
                 Arrays.stream(Farbe.values()).map(farbe -> new Karte(farbe,wert)))
                .collect(Collectors.toList());

        System.out.println(karten);
    }

    @Override
    public String toString() {
       return karten.stream().map(String::valueOf).collect(Collectors.joining(", "));

    }
}
