package org.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AbteilungsleiterTest
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
    public void checkKonstruktor() {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);


        assertEquals(vorname, abteilungsleiter.vorname);
        assertEquals(nachname, abteilungsleiter.nachname);
        assertEquals(identifikator, abteilungsleiter.identifikator);
        assertEquals(grundgehalt, abteilungsleiter.grundGehalt);
        assertEquals(gehaltsfaktorABL, abteilungsleiter.gehaltFaktor);
        assertEquals(geburtsdatum, abteilungsleiter.geburtsdatum);
    }
    @Test
    public void checkGehaltBerechnen()
    {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);

        assertEquals(gehaltsfaktorABL,abteilungsleiter.gehaltFaktor);
        assertEquals(grundgehalt * gehaltsfaktorABL, abteilungsleiter.calculateGehalt());
    }
    @Test
    public void checkGehaltBerechnenAngestellter()
    {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        Angestellter angestellter = new Angestellter(vorname,nachname,identifikator,grundgehalt,geburtsdatum);

        assertEquals(gehaltsfaktorMA,angestellter.gehaltFaktor);
        assertEquals(grundgehalt,angestellter.calculateGehalt());

        abteilungsleiter.befoerdert(angestellter);

        assertEquals(gehaltsfaktorMAbef, angestellter.gehaltFaktor);
        assertEquals(grundgehalt * gehaltsfaktorMAbef, angestellter.calculateGehalt());
    }
    @Test
    public void checkAngestellterBefoerdertNull()
    {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);

        assertThrows(NullPointerException.class, () -> abteilungsleiter.befoerdert(null));
    }
}
