package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funktions
{
    Map<String, List<String>> dictionary = new HashMap<>();
    List<String> meanings = new ArrayList<>();

    public void put(String englischWord)
    {
        dictionary.put(englischWord, meanings);
    }
    public void add(String germanWord)
    {
        meanings.add(germanWord);
    }
}
