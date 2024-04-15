package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbteilungTest
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
    public void checkKonstruktor()
    {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname,nachname,identifikator,grundgehalt,geburtsdatum);
        List<Angestellter> angestellteListe = new ArrayList<>();
        angestellteListe.add(new Angestellter("Anna", "Schmidt", "7D821G", 3000.0, new Date()));
        angestellteListe.add(new Angestellter("Peter", "Müller", "9B321C", 3500.0, new Date()));
        Abteilung abteilung = new Abteilung(abteilungsleiter, angestellteListe);

        assertEquals(abteilungsleiter, abteilung.abteilungsleiter);
    }
    @Test
    public void testAddAngestellter() {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        List<Angestellter> angestellteListe = new ArrayList<>();
        Abteilung abteilung = new Abteilung(abteilungsleiter, angestellteListe);

        Angestellter newAngestellter = new Angestellter("Lisa", "Fischer", "8E432A", 3200.0, new Date());
        abteilung.list.add(newAngestellter);

        assertTrue(abteilung.list.contains(newAngestellter));
    }

    @Test
    public void testRemoveAngestellter() {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        List<Angestellter> angestellteListe = new ArrayList<>();
        Angestellter toBeRemoved = new Angestellter("Lisa", "Fischer", "8E432A", 3200.0, new Date());
        angestellteListe.add(toBeRemoved);
        Abteilung abteilung = new Abteilung(abteilungsleiter, angestellteListe);

        abteilung.list.remove(toBeRemoved);

        assertFalse(abteilung.list.contains(toBeRemoved));
    }

    @Test
    public void testAngestellterInListe() {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        List<Angestellter> angestellteListe = new ArrayList<>();
        Angestellter angestellter = new Angestellter("Anna", "Schmidt", "7D821G", 3000.0, new Date());
        angestellteListe.add(angestellter);
        Abteilung abteilung = new Abteilung(abteilungsleiter, angestellteListe);

        assertTrue(abteilung.list.contains(angestellter));
    }
    @Test
    public void checkAbteilungHinzufuegen() {
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        Angestellter angestellter = new Angestellter(vorname, nachname, identifikator, grundgehalt, geburtsdatum);
        List<Angestellter> angestellteListe = new ArrayList<>();
        angestellteListe.add(angestellter);

        Abteilung abteilung = new Abteilung(abteilungsleiter, angestellteListe);
        Unternehmen unternehmen = new Unternehmen("TestUnternehmen", new ArrayList<>());

        unternehmen.abteilungList.add(abteilung);

        assertEquals("TestUnternehmen", unternehmen.name);
        assertTrue(unternehmen.abteilungList.contains(abteilung));
    }

}