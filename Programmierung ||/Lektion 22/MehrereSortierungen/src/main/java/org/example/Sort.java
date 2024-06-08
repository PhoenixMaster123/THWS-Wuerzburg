package org.example;

import java.util.Comparator;

public class Sort implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2)
    {
        int length = o1.length() - o2.length();
        //int lengthComparison = Integer.compare(o1.length(), o2.length());
        if (length == 0) {
            return o1.compareTo(o2);
        }

        // Ansonsten nach Länge sortieren
        return length;
    }
}
