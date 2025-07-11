package org.example;

import java.util.List;

public class MeldePerson
{
    List<Person> meldeListe;
    public void meldeAn(List<? extends Person> list)
    {
        for (Person person : list)
        {
            meldeListe.add(person);
        }
    }

    List<Dozent> meldeliste;
    public void meldeAn(Person person)
    {
        meldeliste.add(person); //hinzufügen geht nicht
    }



}
