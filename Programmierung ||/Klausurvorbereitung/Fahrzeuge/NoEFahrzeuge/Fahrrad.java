package Klausurvorberaitung.Fahrzeuge.NoEFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.Fahrt;
import Klausurvorberaitung.Fahrzeuge.Fahrzeug;

public class Fahrrad extends Fahrzeug {
   @Override
    public double berechneEntgelt(Fahrt fahrt) {
        return 0.125 * fahrt.min;
    }
}
