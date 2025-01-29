package Klausurvorberaitung.Fahrzeuge.EFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.EFahrzeug;
import Klausurvorberaitung.Fahrzeuge.Fahrt;
import Klausurvorberaitung.Fahrzeuge.Fahrzeug;

public class Elektroroller extends EFahrzeug {
    @Override
    public double berechneEntgelt(Fahrt fahrt) {
        return 3 + 0.15 * fahrt.km;
    }
    @Override
    public void kehreZurückZurLadeStation() {
    }
}
