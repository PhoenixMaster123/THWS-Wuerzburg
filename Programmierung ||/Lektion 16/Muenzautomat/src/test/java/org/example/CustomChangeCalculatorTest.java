package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomChangeCalculatorTest
{
    @Test
    public void testChange()
    {
        CustomChangeCalculator calculator = new CustomChangeCalculator();
        int[] change = calculator.getChange(5,99);
        int[] expected = {0, 2, 1, 0, 2, 1, 1, 2};

        assertArrayEquals(expected,change);

        change = calculator.getChange(10,98);
        expected = new int[]{1, 1, 1, 0, 2, 1, 0, 5};

        assertArrayEquals(expected,change);

        change = calculator.getChange(0, 13);
        expected = new int[]{1, 1, 0, 1, 0, 0, 0, 0};
    }
}