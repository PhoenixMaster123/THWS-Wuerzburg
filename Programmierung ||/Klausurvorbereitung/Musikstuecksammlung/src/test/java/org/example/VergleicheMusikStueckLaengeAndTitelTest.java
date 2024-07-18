package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class VergleicheMusikStueckLaengeAndTitelTest
{
    MusikStueckSammlung sammlung;
    @BeforeEach
    public void prepareTests()
    {
        sammlung = new MusikStueckSammlung();
        sammlung.musikStueckEinfügen(new MusikStueck("Song A", "Interpret A", 180));
        sammlung.musikStueckEinfügen(new MusikStueck("Song C", "Interpret C", 240));
        sammlung.musikStueckEinfügen(new MusikStueck("Song B", "Interpret B", 200));
        sammlung.musikStueckEinfügen(new MusikStueck("Song D", "Interpret D", 210));
    }
    @Test
    public void sortTitel()
    {
        MusikStueck[] alleMusikStuecke = sammlung.getAlleMusikStueckeNachTitel();
        Arrays.sort(alleMusikStuecke, new VergleicheMusikStueckTitel());

        // Überprüfe die Sortierung nach Titel
        assertEquals("Song A", alleMusikStuecke[0].titel);
        assertEquals("Song B", alleMusikStuecke[1].titel);
        assertEquals("Song C", alleMusikStuecke[2].titel);
        assertEquals("Song D", alleMusikStuecke[3].titel);
    }
    @Test
    public void sortLaenge()
    {
        MusikStueck[] alleMusikStuecke = sammlung.getAlleMusikStueckeNachTitel();
        Arrays.sort(alleMusikStuecke, new VergleicheMusikStueckLaenge());

        // Überprüfe die Sortierung nach Titel
        assertEquals("Song A", alleMusikStuecke[0].titel);
        assertEquals("Song B", alleMusikStuecke[1].titel);
        assertEquals("Song D", alleMusikStuecke[2].titel);
        assertEquals("Song C", alleMusikStuecke[3].titel);
    }
}