package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OberflaechenBerechnungTest
{
    @Test
    public void berechneOberflaecheWennAisNegativeZahl()
    {
        assertThrows(RuntimeException.class, () -> OberflaechenBerechnung.berechneOberflaeche(-1,2,3));
    }
    @Test
    public void berechneOberflaecheWennBisNegativeZahl()
    {
        assertThrows(RuntimeException.class, () -> OberflaechenBerechnung.berechneOberflaeche(1, -2,3));
    }
    @Test
    public void berechneOberflaecheWennCisNegativeZahl()
    {
        assertThrows(RuntimeException.class, () -> OberflaechenBerechnung.berechneOberflaeche(1,2,-3));
    }
    @Test
    public void berechneOberflaecheTest()
    {
        assertDoesNotThrow(() -> OberflaechenBerechnung.berechneOberflaeche(2,3,4));
        assertEquals("Die Oberfläche des Quaders beträgt: " + 52,OberflaechenBerechnung.berechneOberflaeche(2,3,4));
    }

}