package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Fahrrad bike1 = new Fahrrad();
        Fahrt fahrt1 = new Fahrt(20, 80);
        System.out.println(bike1.entgelten(fahrt1));
        bike1.trageFahrtInFahrtenbuch(fahrt1);

        Motorroller roller1 = new Motorroller();
        System.out.println(roller1.entgelten(fahrt1));
        roller1.trageFahrtInFahrtenbuch(fahrt1);

        List<Fahrzeug> fahrzeuge = new ArrayList<>();
        fahrzeuge.add(bike1);
        fahrzeuge.add(roller1);
        System.out.println(Umsatzberechner.berechneGesamtumsatz(fahrzeuge));
    }
}