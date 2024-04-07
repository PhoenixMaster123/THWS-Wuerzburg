package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticFunctionTest
{
    @Test
    public void rootsTest()
    {
        QuadraticFunction function = new QuadraticFunction(1,4,-21);

        assertArrayEquals(new double[]{3, -7}, function.roots());
    }
    
    @Test
    public void rootsTestRepeatedRoots() {
        QuadraticFunction function = new QuadraticFunction(1, -6, 9);
        assertArrayEquals(new double[]{3, 3}, function.roots());
    }
}