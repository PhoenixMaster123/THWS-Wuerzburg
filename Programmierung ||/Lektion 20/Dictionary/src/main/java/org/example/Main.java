package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        // Functions dictionary = new Functions();
        Map<String, List<String>> dictionary = new HashMap<>();
        List<String> meaning1 = new ArrayList<>();
        meaning1.add("reinigen");
        meaning1.add("säubern");
        meaning1.add("putzen");

        dictionary.put("to clean", meaning1);

        List<String> meaning2 = new ArrayList<>();
        meaning2.add("vergrößern");
        meaning2.add("wachsen");

        dictionary.put("to expand", meaning2);

        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            List<String> meanings = entry.getValue();
            System.out.println(key + " -> " + meanings);
        }

    }
}