package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Person> personList = new ArrayList<>(List.of(new Person("Joe", "Cool"),
                new Person("Bud","Spencer"),
                new Person("Terese", "Hill")));

        System.out.println(personList); // start list
        Collections.sort(personList, new NachnamenComparator());
        System.out.println(personList); // sort -> nachname
        Collections.sort(personList);
        System.out.println(personList); // sort vorname

        // I always can use anonyme class

        /*
       Collections.sort(personList, new NachnamenComparator()
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
        });
         */
    }
}