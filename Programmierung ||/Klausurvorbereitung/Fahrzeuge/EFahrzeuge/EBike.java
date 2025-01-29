package Klausurvorberaitung.Fahrzeuge.EFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.EFahrzeug;
import Klausurvorberaitung.Fahrzeuge.Fahrt;

public class EBike extends EFahrzeug {
    @Override
    public void kehreZurückZurLadeStation() {
    }

    @Override
    public double berechneEntgelt(Fahrt fahrt) {
        return 0.125 * fahrt.min;
    }
}
