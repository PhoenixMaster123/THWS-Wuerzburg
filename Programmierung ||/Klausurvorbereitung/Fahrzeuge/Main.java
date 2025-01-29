package Klausurvorberaitung.Fahrzeuge;

import Klausurvorberaitung.Fahrzeuge.EFahrzeuge.EBike;
import Klausurvorberaitung.Fahrzeuge.NoEFahrzeuge.Fahrrad;

public class Main {
    public static void main(String[] args) {
        EFahrzeug e = new EBike();
        e.kehreZurückZurLadeStation();

        Fahrzeug f = new Fahrrad();
    }
}
