package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoboterTest
{
    @Test
    public void roboterEntscheideTest()
    {
        Roboter roboter = new Roboter();
        assertEquals(Reaktion.RECHTS, roboter.entscheide(Gefahrensituationen.GEFAHR_LINKS));
        assertEquals(Reaktion.LINKS, roboter.entscheide(Gefahrensituationen.GEFAHR_RECHTS));
        assertEquals(Reaktion.BREMSEN, roboter.entscheide(Gefahrensituationen.GEFAHR_VORNE));
    }
    @Test
    public void entscheide_nullInput()
    {
        Roboter roboter = new Roboter();
        assertThrows(NullPointerException.class, () -> roboter.entscheide(null));
    }
}