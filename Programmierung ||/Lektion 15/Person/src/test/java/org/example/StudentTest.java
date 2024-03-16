package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest
{
    @Test
    public void gibTaetigkeitAusStudentTest()
    {
        String fach = "Biologie";
        Person person = new Student();
        assertEquals("Der Student besucht das Fach Biologie", person.gibTaetigkeitAus(fach));
    }
}