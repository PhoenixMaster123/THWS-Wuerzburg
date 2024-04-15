package org.example;

import java.util.Date;

public class Angestellter
{
     String vorname;
     String nachname;
    String  identifikator;
     double grundGehalt;
     double gehaltFaktor;
     Date geburtsdatum;

    public Angestellter(String vorname, String nachname, String identifikator, double grundGehalt, Date geburtsdatum)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.identifikator = identifikator;
        this.grundGehalt = grundGehalt;
        this.gehaltFaktor = 1.0;
        this.geburtsdatum = geburtsdatum;
    }
    public double calculateGehalt()
    {
        return grundGehalt * gehaltFaktor;
    }
}
