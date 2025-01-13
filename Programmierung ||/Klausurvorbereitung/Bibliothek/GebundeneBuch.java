package Klausurvorberaitung.Bibliothek;

public class GebundeneBuch extends Buch {
    private int seitenzahl;
    public GebundeneBuch(String name, String author, String verlag, int preisInCent, int seitenzahl) {
        super(name, author, verlag, preisInCent);
        this.seitenzahl = seitenzahl;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }
}
