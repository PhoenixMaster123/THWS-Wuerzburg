package org.example;

import java.util.List;

public class Unternehmen
{
    String name;
    List<Abteilung> abteilungList;

    Unternehmen(String name, List<Abteilung> abteilungList)
    {
        this.name = name;
        this.abteilungList = abteilungList;
    }
}
