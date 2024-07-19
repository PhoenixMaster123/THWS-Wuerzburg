package org.example;

public class Raetselbuch extends Buch {
    public boolean einmalSpielbar;

    public Raetselbuch(String name, double priceInCents, double gewichtInGramm, int seitenAnzahl, boolean einmalSpielbar) {
        super(name, priceInCents, gewichtInGramm, seitenAnzahl);
        this.einmalSpielbar = einmalSpielbar;
    }
}


