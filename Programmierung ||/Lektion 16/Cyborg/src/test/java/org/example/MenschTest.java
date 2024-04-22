package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenschTest
{
    @Test
    public void entscheideTest()
    {
        Mensch mensch = new Mensch()
        {
            public double random()
            {
                return 0.3;
            }
        };

        assertEquals(Reaktion.RECHTS, mensch.entscheide(Gefahrensituationen.GEFAHR_LINKS));
        assertEquals(Reaktion.LINKS, mensch.entscheide(Gefahrensituationen.GEFAHR_RECHTS));
        assertEquals(Reaktion.BREMSEN, mensch.entscheide(Gefahrensituationen.GEFAHR_VORNE));
    }
    @Test
    public void entscheideUNENTSCHIEDENTest()
    {
        Mensch mensch = new Mensch() {
            @Override
            public double random() {
                return 0.25; // Simulate random value less than or equal to 0.25
            }
        };
        assertEquals(Reaktion.UNENTSCHIEDEN, mensch.entscheide(Gefahrensituationen.GEFAHR_LINKS));
    }
    @Test
    void entscheide_nullInput() {
        Mensch mensch = new Mensch();
        assertThrows(NullPointerException.class, () -> mensch.entscheide(null));
    }
}