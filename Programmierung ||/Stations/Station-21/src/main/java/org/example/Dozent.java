package org.example;

    public class Dozent extends Person
    {
        String fach;
        public Dozent(String vorname, String name, String fach)
        {
            super(vorname, name);
            this.fach = fach;
        }
    }
