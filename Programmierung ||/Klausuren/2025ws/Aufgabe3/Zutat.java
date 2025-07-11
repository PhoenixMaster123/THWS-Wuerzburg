package Klausurvorberaitung.ws2025.Aufgabe3;

public class Zutat {
    // a)
    public String name;
    public Einheit einheit;
    public double mengeInGramm;

    private Zutat(String name, Einheit einheit, double mengeInGramm) {
        this.name = name;
        this.einheit = einheit;
        this.mengeInGramm = mengeInGramm;
    }

    // Factory method
    public static Zutat of(String name, Einheit einheit, double menge) {
        return new Zutat(name, einheit, menge);
    }
}
