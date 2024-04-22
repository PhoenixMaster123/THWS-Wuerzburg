package org.example;

import java.util.List;

public class Stack2 implements StackInterface
{
    ArrayList list = new ArrayList();
    @Override
    public void push(Object value)
    {
        list.add(value);
    }

    @Override
    public Object pop() {

        if(list.size() == 0)
        {
            throw new IllegalStateException();
        }
        else
        {
            return list.remove(list.size() - 1);
        }
    }
}
