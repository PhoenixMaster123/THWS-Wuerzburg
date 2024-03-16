package org.example;

public class Angestellter
{
    protected String vorname;
    protected String nachname;
    protected int identifikator;
    protected double grundGehalt;
    protected double gehaltFaktor;
    protected String geburtsdatum;

    public Angestellter(String vorname, String nachname, int identifikator, double grundGehalt, double gehaltFaktor, String geburtsdatum)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.identifikator = identifikator;
        this.grundGehalt = grundGehalt;
        this.gehaltFaktor = gehaltFaktor;
        this.geburtsdatum = geburtsdatum;
    }
    public double calculateGehalt()
    {
        return grundGehalt * gehaltFaktor;
    }
}
