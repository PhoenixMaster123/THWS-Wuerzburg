package Klausurvorberaitung.ss2024.Aufgabe3_Warenkorb;

import java.util.HashMap;
import java.util.Map;

public class Warenkorb{
    Map<Artikel, Integer> korb = new HashMap<>();

    // a)
    public void add(Artikel artikel, Integer value) {
        if(!korb.containsKey(artikel)) {
           korb.put(artikel, value);
        }
    }
    // b)
    public void priceInArtikels(ArtikelKategorie... value) {
        for (ArtikelKategorie artikelKategorie : value) {
            System.out.println(gesamtPreisKategorie(artikelKategorie));
        }
    }
    // c)
    private int gesamtPreisKategorie(ArtikelKategorie kategorie) {
        int total = 0;

        for (Artikel artikel : korb.keySet()) {
            if(artikel.artikelKategorie == kategorie) {
                total += artikel.priceInCent * korb.get(artikel);
            }
        }
        return total;
    }
}
