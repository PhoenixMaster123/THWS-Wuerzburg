package org.example;

import java.util.ArrayList;
import java.util.List;


public class Artikel
{
    String name;
    double priceInCents;
    double gewichtInGramm;

    public Artikel(String name, double priceInCents, double gewichtInGramm)
    {
        this.name = name;
        this.priceInCents = priceInCents;
        this.gewichtInGramm = gewichtInGramm;
    }

    public static List<Artikel> filterEinmalSpielbar(List<Artikel> artikels)
    {
        List<Artikel> result = new ArrayList<>();
        for (Artikel artikel : artikels)
        {
            if (artikel instanceof Raetselbuch && ((Raetselbuch) artikel).einmalSpielbar ||
                artikel instanceof Rätselspiel && ((Rätselspiel) artikel).einmalSpielbar)
            {
                result.add(artikel);
            }
        }
        return result;
        /*return artikels.stream()
                .filter(x -> x instanceof Rätselspiel || x instanceof Raetselbuch)
                .filter(x -> {
                    if (x instanceof Rätselspiel) {
                        return ((Rätselspiel) x).einmalSpielbar;
                    } else {
                        return ((Raetselbuch) x).einmalSpielbar;
                    }
                }).toList();
         */

    }
}
