package org.example;

import java.util.Date;

public class Abteilungsleiter extends Angestellter {
    public Abteilungsleiter(String vorname, String nachname, String identifikator, double grundGehalt, Date geburtsdatum) {
        super(vorname, nachname, identifikator, grundGehalt, geburtsdatum);
        this.gehaltFaktor = 2.0;
    }

    public double befoerdert(Angestellter angestellter) {
        if (angestellter != null) {
            return angestellter.gehaltFaktor *= 1.1;
        } else {
            throw new NullPointerException("Angestellter darf nicht null sein");
        }
    }
}
