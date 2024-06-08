package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)
    {
        TreeSet<String> t = new TreeSet<>(new Sort());
        t.addAll(Arrays.asList(Kreuzwortraetsel.alleWoerter));
        for(String wort : t)
            System.out.println(wort);

        // Without lambda
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() { // or ->
            @Override
            public int compare(String s1, String s2) {
                int length = Integer.compare(s1.length(),s2.length());
                if(length == 0)
                {
                    return s1.compareTo(s2);
                }
                return length;
            }
        });
        treeSet.addAll(Arrays.asList(Kreuzwortraetsel.alleWoerter));

        // with Lambda
        /*TreeSet<String> s = new TreeSet<>((s1, s2) -> {
            int length = Integer.compare(s1.length(),s2.length());
            if(length == 0)
            {
                return s1.compareTo(s2);
            }
            return length;
        });
        treeSet.addAll(Arrays.asList(Kreuzwortraetsel.alleWoerter));
         */
        for (String wort : t) {
            System.out.println(wort);
        }
    }
}