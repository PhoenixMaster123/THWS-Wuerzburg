package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest
{

    @Test
    public void gibTaetigkeitAusProffesorTest()
    {
        String fach = "Mathe";
        Person person = new Professor();
        assertEquals("Der Professor unterrichtet Mathe", person.gibTaetigkeitAus(fach));
    }
}