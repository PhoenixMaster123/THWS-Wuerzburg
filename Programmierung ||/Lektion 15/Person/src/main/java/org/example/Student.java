package org.example;

public class Student extends Person{

    Student(String fach) {
        super(fach);
    }

    @Override
    public String gibTaetigkeitAus()
    {
        return "Der Student besucht das Fach " + fach;
    }
}
