package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaerbaumTest
{
    Binaerbaum baum;
    @BeforeEach
    public void prepareTests()
    {
        baum = new Binaerbaum();
        baum.insert(new Binaerbaum.Knoten("Simon")); // root
        baum.insert(new Binaerbaum.Knoten("Maria")); // left
        baum.insert(new Binaerbaum.Knoten("Helmi")); // left - left
        baum.insert(new Binaerbaum.Knoten("Zylla")); // right
        /*
                     Simon
                   /       \
                  /         \
                Maria       Zylla
                /    \      /    \
              Helmi  null  null  null

         */
    }
    @Test
    public void testInsert()
    {
        assertEquals("Maria", baum.root.left.getNachname());
        assertEquals("Simon", baum.root.getNachname());
        assertEquals("Helmi", baum.root.left.left.getNachname());
        assertEquals("Zylla", baum.root.right.getNachname());

    }
    @Test
    public void NullPointerExceptionTest()
    {
        assertThrows(NullPointerException.class, () -> baum.root.right.right.getNachname());
    }
}