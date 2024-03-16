package org.example;

public class Professor extends Person{
    @Override
    public String gibTaetigkeitAus(String fach)
    {
        return "Der Professor unterrichtet " + fach;
    }
}
