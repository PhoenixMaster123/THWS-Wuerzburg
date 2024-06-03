package org.example;


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        Dictionary dictionary = new Dictionary();
        dictionary.put("to clean", "reinigen");

        Set<String> set = new HashSet<>();
        set.add("säubern");
        set.add("putzen");
        dictionary.put("to clean", set);

        printSetToConsole(dictionary.get("to clean"));

        dictionary.put("to clean", "reinigen");

        printSetToConsole(dictionary.get("to clean"));

        printSetToConsole(dictionary.get("to test"));

        dictionary.put("to test", "testen");

        printSetToConsole(dictionary.get("to test"));

    }
    private static void printSetToConsole(Set<String> set)
    {
        if(set != null)
        {
            for (String s : set)
            {
                System.out.println(s);
            }
        }
        else
        {
            System.out.println("Not in the dictionary!");
        }
        System.out.println("- - - - - -");
    }
}