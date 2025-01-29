package Klausurvorberaitung.Fahrzeuge;

import java.util.ArrayList;
import java.util.List;

public class Umsatzberechner{
    public double gesamtUmsatz(List<Fahrzeug> fahrzeugList) {
        double gesamtUmsatz = 0;
        for (Fahrzeug fahrzeug : fahrzeugList) {
            for (Fahrt fahrt : fahrzeug.fahrtenBuch) {
                gesamtUmsatz += fahrzeug.berechneEntgelt(fahrt);
            }
        }
        return gesamtUmsatz;
    }
    public double berechneElektroumsatz(List<EFahrzeug> elektroFahrzeuge) {
        return gesamtUmsatz(new ArrayList<>(elektroFahrzeuge));
    }
}
