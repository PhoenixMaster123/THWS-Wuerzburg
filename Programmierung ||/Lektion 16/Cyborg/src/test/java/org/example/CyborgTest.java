package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CyborgTest {

    @Test
    public void testMenschRoboterEinig() {
        Mensch mensch = new Mensch();
        Roboter roboter = new Roboter();
        Cyborg cyborg = new Cyborg(mensch, roboter);

        Gefahrensituationen gefahrensituation = Gefahrensituationen.GEFAHR_LINKS;
        Reaktion entscheidung = cyborg.entscheide(gefahrensituation);

        assertEquals(Reaktion.RECHTS, entscheidung);
    }

    @Test
    public void testMenschRoboterUneinig() {
        Mensch mensch = new Mensch();
        Roboter roboter = new Roboter();
        Cyborg cyborg = new Cyborg(mensch, roboter);

        Gefahrensituationen gefahrensituation = Gefahrensituationen.GEFAHR_VORNE;

        // Mensch entscheidet sich für Bremsen, Roboter für Links

        //mensch.entscheide = () -> Gefahrensituationen.BREMSEN;
        //roboter.entscheide = () -> Gefahrensituationen.LINKS;

        mensch.entscheide(Gefahrensituationen.GEFAHR_VORNE);
        roboter.entscheide(Gefahrensituationen.GEFAHR_RECHTS);

        Reaktion entscheidung = cyborg.entscheide(gefahrensituation);

        // Zufällige Entscheidung zwischen Bremsen und Links
        assertTrue(entscheidung == Reaktion.BREMSEN || entscheidung == Reaktion.LINKS);
    }

    @Test
    public void testMenschUnentschieden() {
        Mensch mensch = new Mensch() {
            @Override
            public double random() {
                return 0.25; // Simulate random value less than or equal to 0.25
            }
        };
        Roboter roboter = new Roboter();
        Cyborg cyborg = new Cyborg(mensch, roboter);

        Gefahrensituationen gefahrensituation = Gefahrensituationen.GEFAHR_LINKS;

        // Mensch ist unentschieden, Roboter entscheidet sich für Links

       // mensch.entscheide = () -> Gefahrensituationen.UNENTSCHIEDEN;
       // roboter.entscheide = () -> Gefahrensituationen.LINKS;

        Reaktion menschTeil = mensch.entscheide(Gefahrensituationen.GEFAHR_LINKS);
        Reaktion roboterTeil = roboter.entscheide(Gefahrensituationen.GEFAHR_RECHTS);

        Reaktion entscheidung = cyborg.entscheide(gefahrensituation);

        // Entscheidung muss Links sein
        assertTrue(entscheidung == menschTeil || entscheidung == roboterTeil);
    }

    @Test
    public void testNullGefahrensituation() {
        Mensch mensch = new Mensch();
        Roboter roboter = new Roboter();
        Cyborg cyborg = new Cyborg(mensch, roboter);

        assertThrows(NullPointerException.class, () -> cyborg.entscheide(null));
    }
}
