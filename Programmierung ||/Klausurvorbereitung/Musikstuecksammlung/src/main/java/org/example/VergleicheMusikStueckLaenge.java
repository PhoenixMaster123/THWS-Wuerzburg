package org.example;

import java.util.Comparator;

public class VergleicheMusikStueckLaenge implements Comparator<MusikStueck> {

    @Override
    public int compare(MusikStueck t1, MusikStueck t2)
    {
        return Integer.compare(t1.laenge, t2.laenge);
       // return t1.laenge - t2.laenge;

        /*
         if (t1.laenge < t2.laenge) {
            return -1;
        } else if (t1.laenge > t2.laenge) {
            return 1;
        } else {
            return 0;
        }
         */
    }
}
