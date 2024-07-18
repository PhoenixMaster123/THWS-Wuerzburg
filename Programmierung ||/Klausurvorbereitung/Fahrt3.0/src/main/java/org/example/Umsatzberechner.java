package org.example;

import java.util.ArrayList;
import java.util.List;

public class Umsatzberechner
{
    Fahrzeug fahrzeug;

    private static double berechneGesamtumsatzHelper(List<? extends IFahrzeug> fahrzeuge)
    {
        double total = 0;
        for (IFahrzeug fahrzeug : fahrzeuge)
        {
            for (Fahrt fahrt : fahrzeug.getFahrtenbuch())
            {
                total += fahrzeug.entgelten(fahrt);
            }
        }
        return total;
    }
    public static double berechneGesamtumsatz(List<Fahrzeug> fahrzeuge) {
        return berechneGesamtumsatzHelper(fahrzeuge);
    }
    public static double berechneElektroumsatz(List<ElektroFahrzeug> EFahrzeugs)
    {
        return berechneGesamtumsatzHelper(EFahrzeugs);
    }
}
