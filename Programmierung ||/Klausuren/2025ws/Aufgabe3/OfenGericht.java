package Klausurvorberaitung.ws2025.Aufgabe3;

import java.util.List;

public class OfenGericht extends Gericht {
    String einstellungen;
    public OfenGericht(String name, List<Zutat> zutatList, int anzahlPersonen, String einstellungen) throws InvalidGerichtException {
        super(name, zutatList, anzahlPersonen);
        this.einstellungen = einstellungen;
    }
}
