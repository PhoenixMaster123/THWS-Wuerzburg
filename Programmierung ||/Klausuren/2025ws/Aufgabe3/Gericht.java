package Klausurvorberaitung.ws2025.Aufgabe3;

import java.util.List;

public abstract class Gericht {
    String name;
    List<Zutat> zutatList;
    int anzahlPersonen;

    public Gericht(String name, List<Zutat> zutatList, int anzahlPersonen) throws InvalidGerichtException{
        this.name = name;
        try {
            if (zutatList.size() < 0 || anzahlPersonen < 1) {
                throw new InvalidGerichtException("ZutatListe darf nicht leer sein");
            } else {
                this.zutatList = zutatList;
                this.anzahlPersonen = anzahlPersonen;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
