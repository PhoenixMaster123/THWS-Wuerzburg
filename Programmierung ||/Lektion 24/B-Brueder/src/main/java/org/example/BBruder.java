package org.example;

import java.util.ArrayList;
import java.util.List;

public class BBruder {
    String name;
    int bankDrueckenGewicht;
    int knieBeugenGewicht;
    List<String> kampfSportBuecher = new ArrayList<>();

    public BBruder(String name, int bankDrueckenGewicht, int
            knieBeugenGewicht) {
        this.name = name;
        this.bankDrueckenGewicht = bankDrueckenGewicht;
        this.knieBeugenGewicht = knieBeugenGewicht;
    }
    public BBruder add(String... buecher)
    {
        kampfSportBuecher.addAll(List.of(buecher));
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Bankdrücken: %dkg, Kniebeugen %dkg",
                name, bankDrueckenGewicht, knieBeugenGewicht);
    }
}
