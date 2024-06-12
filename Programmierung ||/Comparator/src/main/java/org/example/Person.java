package org.example;

import java.util.*;

public class Person //implements Comparable<Person>
{
    String vorname;
    String nachname;
    int alter;

    public Person(String vorname, String nachname, int alter)
    {
        this.vorname = vorname;
        this.nachname =nachname;
        this.alter = alter;
    }
    public String toString()
    {
        return vorname + " " + nachname + " " + alter;
    }

    /*@Override
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
     */
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Terence", "Hill", 27));
        persons.add(new Person("Bud", "Spencer", 15));
        Collections.sort(persons, new VornameComparator());
        System.out.println(persons);

        //
        Collections.sort(persons, (p1, p2) -> {
            if (p1.vorname.equals(p2.vorname)) {
                return p1.nachname.compareTo(p2.nachname);
            } else {
                return p1.vorname.compareTo(p2.vorname);
            }
        });
        // shorter
        /*Collections.sort(persons, (p1, p2)
                -> p1.vorname.equals(p2.vorname)
                ? p1.nachname.compareTo(p2.nachname)
                : p1.vorname.compareTo(p2.vorname));
        }
         */
        List<Person> list = persons.stream().filter(p -> p.alter >= 18).toList(); // we don't need to use collect
        System.out.println(list);
    }
}
