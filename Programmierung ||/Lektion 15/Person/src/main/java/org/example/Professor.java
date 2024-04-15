package org.example;

public class Professor extends Person{
    Professor(String fach) {
        super(fach);
    }

    @Override
    public String gibTaetigkeitAus()
    {
        return "Der Professor unterrichtet " + fach;
    }
}
