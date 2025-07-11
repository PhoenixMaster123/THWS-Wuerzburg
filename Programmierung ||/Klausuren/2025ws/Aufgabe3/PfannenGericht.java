package Klausurvorberaitung.ws2025.Aufgabe3;

import java.util.List;

public class PfannenGericht extends Gericht {
    public PfannenGericht(String name, List<Zutat> zutatList, int anzahlPersonen) throws InvalidGerichtException {
        super(name, zutatList, anzahlPersonen);
    }
}
