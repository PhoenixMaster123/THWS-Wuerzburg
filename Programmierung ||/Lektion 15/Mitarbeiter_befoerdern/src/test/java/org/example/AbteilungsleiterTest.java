package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbteilungsleiterTest {
    @Test
    public void AngestellterbefoerdertTest() {
        Angestellter employee1 = new Angestellter("Mustermann", "Max", 1, 50000, 2, "1990-5-15");

        Abteilungsleiter leader = new Abteilungsleiter("Leiter", "Hans", 100, 80000, 1, "1978-8-20");
        assertEquals(110000, leader.Angestellterbefoerdert(employee1));
    }
}
