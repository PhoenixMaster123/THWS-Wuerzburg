package org.example;


public class StringToInteger implements Transform<String,Integer>
{
    @Override
    public Integer transform(String from)
    {
        return Integer.valueOf(from);
    }
}
