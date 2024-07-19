package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtikelTest
{
    @Test
    public void filterEinmalSpielbarTest()
    {
        Artikel artikel1 = new Rätselspiel("Spiel1", 1000, 500, true);
        Artikel artikel2 = new Raetselbuch("Buch1", 1500, 700, 200, true);
        Artikel artikel3 = new Rätselspiel("Spiel2", 2000, 800, false);
        List<Artikel> artikels = Arrays.asList(artikel1, artikel2, artikel3);

        List<Artikel> result = Artikel.filterEinmalSpielbar(artikels);

        assertEquals(2, result.size());
        assertTrue(result.contains(artikel1));
        assertTrue(result.contains(artikel2));
    }
}