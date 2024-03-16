package org.example;

public class Abteilungsleiter extends Angestellter {
    public Abteilungsleiter(String vorname, String nachname, int identifikator, double grundGehalt, double gehaltFaktor, String geburtsdatum) {
        super(vorname, nachname, identifikator, grundGehalt, gehaltFaktor, geburtsdatum);
    }

    public double Angestellterbefoerdert(Angestellter angestellter) {
        return angestellter.calculateGehalt() + angestellter.calculateGehalt() * 0.1;
    }
}
