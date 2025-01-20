package Klausurvorberaitung.ss2024.Aufgabe3_Warenkorb;

public class Artikel {
    public String name;
    public int priceInCent;
    ArtikelKategorie artikelKategorie;

    public Artikel(String name, int priceInCent, ArtikelKategorie artikelKategorie) {
        this.name = name;
        this.priceInCent = priceInCent;
        this.artikelKategorie = artikelKategorie;
    }

}
