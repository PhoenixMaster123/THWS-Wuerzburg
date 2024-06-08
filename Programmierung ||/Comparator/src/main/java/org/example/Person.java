package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person>
{
    String vorname;
    String nachname;

    public Person(String vorname, String nachname)
    {
        this.vorname = vorname;
        this.nachname =nachname;
    }
    public String toString()
    {
        return vorname + " " + nachname;
    }

    @Override
    public int compareTo(Person p) {
        if(this.vorname.compareTo(p.vorname) == 0)
        {
            return this.nachname.compareTo(p.nachname);
        }
        else
        {
            return this.vorname.compareTo(p.vorname);
        }
    }
}
