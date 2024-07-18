package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

public class MusikStueckSammlung
{
    HashMap<String,MusikStueck> map = new HashMap<>();
    public void musikStueckEinfügen(MusikStueck neu)
    {
        if(!map.containsKey(neu.titel))
        {
            map.put(neu.titel, neu);
        }
        else
        {
            throw new IllegalArgumentException("The titel already exists");
        }
    }
    public MusikStueck[] getAlleMusikStueckeNachTitel()
    {
        Collection<MusikStueck> values = map.values();
        MusikStueck[] sortedArray = values.toArray(new MusikStueck[0]);
        Arrays.sort(sortedArray, new VergleicheMusikStueckTitel());
        return sortedArray;
    }
}
