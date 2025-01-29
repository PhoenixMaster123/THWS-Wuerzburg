package Klausurvorberaitung.Fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug{
    public List<Fahrt> fahrtenBuch = new ArrayList<>();
    public abstract double berechneEntgelt(Fahrt fahrt);
    public void addFahrzeug(Fahrt fahrt) {
        fahrtenBuch.add(fahrt);
    }
}
