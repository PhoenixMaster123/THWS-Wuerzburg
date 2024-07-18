package org.example;

import java.util.Comparator;

public class VergleicheMusikStueckTitel implements Comparator<MusikStueck>
{

    @Override
    public int compare(MusikStueck t1, MusikStueck t2) {
        return t1.titel.compareTo(t2.titel);
    }
}
