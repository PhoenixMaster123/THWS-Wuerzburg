package org.example;

public class Rätselspiel extends Artikel
{
    public boolean einmalSpielbar;
    public Rätselspiel(String name, double priceInCents, double gewichtInGramm, boolean einmalSpielbar) {
        super(name, priceInCents, gewichtInGramm);
        this.einmalSpielbar = einmalSpielbar;
    }
}
