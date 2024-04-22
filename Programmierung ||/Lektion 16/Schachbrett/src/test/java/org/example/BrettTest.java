package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrettTest
{
    @Test
    public void markierteFelderTest()
    {
        Brett brett1 = new Brett();

        brett1.markiereFeld(2,3);
        brett1.markiereFeld(7,8);
        brett1.markiereFeld(5,6);

        assertTrue(brett1.gibFeld(2,3));
        assertTrue(brett1.gibFeld(7,8));
        assertTrue(brett1.gibFeld(5,6));
    }
    @Test
    public void kombinierenBrettTest()
    {
        Brett brett1 = new Brett();
        brett1.markiereFeld(2, 3);
        brett1.markiereFeld(4, 5);
        brett1.markiereFeld(7, 1);

        Brett brett2 = new Brett();
        brett2.markiereFeld(3, 3);
        brett2.markiereFeld(5, 5);
        brett2.markiereFeld(6, 7);

        Brett kombinieren = brett1.kombiniere(brett2);

        assertTrue(kombinieren.gibFeld(2,3));
        assertTrue(kombinieren.gibFeld(3,3));
        assertTrue(kombinieren.gibFeld(7,1));
        assertTrue(kombinieren.gibFeld(6,7));

        assertFalse(kombinieren.gibFeld(1,7));
        assertFalse(kombinieren.gibFeld(2,2));
        assertFalse(kombinieren.gibFeld(4,3));
        assertFalse(kombinieren.gibFeld(6,6));
    }

    @Test
    public void kombinierenLeeresBrett()
    {
        Brett brett1 = new Brett();
        Brett brett2 = new Brett();

        Brett kombinieren = brett1.kombiniere(brett2);

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                assertFalse(kombinieren.gibFeld(i, j));
            }
        }
    }
    @Test
    public void kombinierenMitLeeremBrettTest()
    {
        Brett brett1 = new Brett();

        brett1.markiereFeld(2, 3);
        brett1.markiereFeld(4, 5);
        brett1.markiereFeld(7, 1);

        Brett brett2 = new Brett();

        Brett kombinieren = brett1.kombiniere(brett2);

        assertTrue(kombinieren.gibFeld(2,3));
        assertTrue(kombinieren.gibFeld(4,5));
        assertTrue(kombinieren.gibFeld(7,1));

        assertFalse(kombinieren.gibFeld(2,2));
        assertFalse(kombinieren.gibFeld(1,7));
    }
    @Test
    public void kombinierenMitSichSelbsBrettTest()
    {
        Brett brett1 = new Brett();

        brett1.markiereFeld(2, 3);
        brett1.markiereFeld(4, 5);
        brett1.markiereFeld(7, 1);


        Brett kombinieren = brett1.kombiniere(brett1);

        assertTrue(kombinieren.gibFeld(2,3));
        assertTrue(kombinieren.gibFeld(4,5));
        assertTrue(kombinieren.gibFeld(7,1));

        assertFalse(kombinieren.gibFeld(2,2));
        assertFalse(kombinieren.gibFeld(1,7));
    }
}