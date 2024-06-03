package org.example;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary
{
    HashMap<String, Set<String>> map = new HashMap<>();
    public void put(String englisch, Set<String> german)
    {
        for (String germanWord : german)
        {
            put(englisch,germanWord);
        }
    }
    public void put(String englisch, String german)
    {
        if(map.containsKey(englisch))
        {
            Set<String> updateGermanTranslation = map.get(englisch);
            updateGermanTranslation.add(german);
            map.put(englisch,updateGermanTranslation);
        }
        else
        {
            Set<String> germanTranslationSet = new TreeSet<>();
            germanTranslationSet.add(german);
            map.put(englisch,germanTranslationSet);
        }
    }
    public Set<String> get(String englisch)
    {
        return map.get(englisch);
    }
}
