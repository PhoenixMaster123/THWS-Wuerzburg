package org.example;

import java.util.Comparator;

public class NachnamenComparator implements Comparator<Person> // Comparator multi-sorting / Comparable vor only one
{

    @Override
    public int compare(Person p1, Person p2) {

        if(p1.nachname.compareTo(p2.nachname) == 0)
        {
            return p1.vorname.compareTo(p2.vorname);
        }
        else
        {
            return p1.nachname.compareTo(p2.nachname);
        }
    }
}
