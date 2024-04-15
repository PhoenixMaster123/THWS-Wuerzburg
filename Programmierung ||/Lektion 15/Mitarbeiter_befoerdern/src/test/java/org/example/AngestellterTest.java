package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AngestellterTest
{

    static final String vorname = "Max";
    static final String nachname = "Mustermann";
    static final String identifikator = "4F541E";
    static final double grundgehalt = 2845.65;
    static final double gehaltsfaktorMA = 1.0;
    static final double gehaltsfaktorMAbef = 1.1;
    static final double gehaltsfaktorABL = 2.0;

    static final Date geburtsdatum = new Date(2000,01,01);

    @Test
    public void checkKonstruktorTest()
    {
        Angestellter angestellter = new Angestellter(vorname,nachname,identifikator,grundgehalt,geburtsdatum);

        assertEquals(vorname, angestellter.vorname);
        assertEquals(nachname, angestellter.nachname);
        assertEquals(identifikator, angestellter.identifikator);
        assertEquals(grundgehalt, angestellter.grundGehalt);
        assertEquals(gehaltsfaktorMA, angestellter.gehaltFaktor);
        assertEquals(geburtsdatum, angestellter.geburtsdatum);
    }
    @Test
    public void checkGehaltBerechnung()
    {
        Angestellter angestellter = new Angestellter(vorname,nachname,identifikator,grundgehalt,geburtsdatum);

        assertEquals(gehaltsfaktorMA, angestellter.gehaltFaktor);
        assertEquals(grundgehalt, angestellter.calculateGehalt());
    }
    @Test
    public void testGehaltsfaktorErhoehen() {
        Angestellter angestellter = new Angestellter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);

        angestellter.gehaltFaktor = gehaltsfaktorMA;
        angestellter.gehaltFaktor *= 1.1;

        assertEquals(gehaltsfaktorMAbef, angestellter.gehaltFaktor);
    }
}