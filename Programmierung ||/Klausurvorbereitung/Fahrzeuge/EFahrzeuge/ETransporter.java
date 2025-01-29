package Klausurvorberaitung.Fahrzeuge.EFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.EFahrzeug;
import Klausurvorberaitung.Fahrzeuge.Fahrt;

public class ETransporter extends EFahrzeug {
    @Override
    public void kehreZurückZurLadeStation() {
    }
    @Override
    public double berechneEntgelt(Fahrt fahrt) {
        if(fahrt.min <= 60) {
            return 0.30 * fahrt.km;
        } else {
            int zusatzMinuten = fahrt.min - 60;
            return fahrt.km * 0.30 + zusatzMinuten * 0.25;
        }
    }
}
