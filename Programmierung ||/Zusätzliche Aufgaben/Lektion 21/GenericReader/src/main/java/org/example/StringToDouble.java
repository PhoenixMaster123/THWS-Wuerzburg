package org.example;


public class StringToDouble implements Transform<String,Double>
{
    public Double transform(String from)
    {
        return Double.valueOf(from);
    }
}
