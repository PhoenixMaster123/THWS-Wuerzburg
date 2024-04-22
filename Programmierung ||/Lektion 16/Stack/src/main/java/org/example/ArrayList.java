package org.example;

import java.util.List;

public class ArrayList
{
    static final List<Integer> list = new java.util.ArrayList<>();

    public void add(Object value)
    {
        list.add((Integer) value);
    }
    public Object remove(Object value)
    {
        list.remove(value);
        return value;
    }
    public int size()
    {
        return list.size();
    }
}
