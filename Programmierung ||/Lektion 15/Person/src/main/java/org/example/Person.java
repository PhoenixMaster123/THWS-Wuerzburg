package org.example;

public abstract class Person
{
    String fach;
    Person(String fach)
    {
        this.fach = fach;
    }
    public abstract String gibTaetigkeitAus();
}
