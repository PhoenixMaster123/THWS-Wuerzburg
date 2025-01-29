package Klausurvorberaitung.Fahrzeuge.NoEFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.Fahrt;
import Klausurvorberaitung.Fahrzeuge.Fahrzeug;

public class Motorroller extends Fahrzeug {
    @Override
    public double berechneEntgelt(Fahrt fahrt) {
        return 3 + 0.15 * fahrt.km;
    }
}
