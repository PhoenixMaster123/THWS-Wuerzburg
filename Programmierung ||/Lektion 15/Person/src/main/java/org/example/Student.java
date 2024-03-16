package org.example;

public class Student extends Person{

    @Override
    public String gibTaetigkeitAus(String fach)
    {
        return "Der Student besucht das Fach " + fach;
    }
}
