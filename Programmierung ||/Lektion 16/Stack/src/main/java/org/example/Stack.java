package org.example;

import java.util.ArrayList;

public class Stack  extends ArrayList implements StackInterface
{

    @Override
    public void push(Object value) {
       // super.add(value);
        add(value);
    }
    @Override
    public Object pop() {
        if (size() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return remove(size() - 1);
    }
}
