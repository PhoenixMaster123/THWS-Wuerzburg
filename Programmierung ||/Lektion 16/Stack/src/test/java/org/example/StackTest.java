package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest
{
    @Test
    public void testStackFunktions()
    {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.size());
        Object fromStack = stack.pop();
        assertEquals(1,fromStack);
        assertEquals(0,stack.size());
    }
    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        Stack stack = new Stack();

        assertThrows(IllegalStateException.class, stack::pop);
    }
}