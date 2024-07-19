package org.example;

public class Buch extends Artikel
{
    int seitenAnzahl;
    public Buch(String name, double priceInCents, double gewichtInGramm, int seitenAnzahl)
    {
        super(name, priceInCents, gewichtInGramm);
        this.seitenAnzahl = seitenAnzahl;

    }
    public double preisProSeite()
    {
        return priceInCents / seitenAnzahl;
    }
}
