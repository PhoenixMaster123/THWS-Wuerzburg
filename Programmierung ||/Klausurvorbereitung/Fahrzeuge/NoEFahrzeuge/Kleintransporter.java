package Klausurvorberaitung.Fahrzeuge.NoEFahrzeuge;

import Klausurvorberaitung.Fahrzeuge.Fahrt;
import Klausurvorberaitung.Fahrzeuge.Fahrzeug;

public class Kleintransporter extends Fahrzeug {
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
