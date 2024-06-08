package org.example;

import java.util.Comparator;

public class VornameCompable implements Comparable<Person> {
    Person p1;
    @Override
    public int compareTo(Person o) {
        if(p1.nachname.compareTo(o.nachname) == 0)
        {
            return p1.vorname.compareTo(o.vorname);
        }
        else
        {
            return p1.nachname.compareTo(o.nachname);
        }
    }
}
