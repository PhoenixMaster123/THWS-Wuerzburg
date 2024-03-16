package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngestellterTest
{
    @Test
    public void calculateGehaltTest()
    {
        Angestellter angestellter = new Angestellter("Mustermann", "Max", 1, 50000, 2, "1990-5-15");

        assertEquals(100000, angestellter.calculateGehalt());
    }

}