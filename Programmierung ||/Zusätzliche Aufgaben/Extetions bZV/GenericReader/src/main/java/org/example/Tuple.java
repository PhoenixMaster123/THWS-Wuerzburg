package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Tuple<K,V>
{
    final K item1;
    final V item2;

    public Tuple(K item1, V item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public static <K,V> Tuple<K,V> of(K item1, V item2)
    {
        return new Tuple<>(item1,item2);
    }
    public String toString()
    {
        return item1.toString() + "; " + item2.toString();
    }
    // Wrong interpretation:
   /* public static LinkedHashMap<String, List<Double>> readFileDouble() throws IOException
    {
        LinkedHashMap<String, List<Double>> listDouble = new LinkedHashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("einkaufen.txt")))
        {
          String line;
          while ((line = reader.readLine()) != null)
          {
              String[] parts = line.split(";");
              String day = parts[0];
              String[] elements = parts[1].split(",");
              ArrayList<Double> listOfDouble = new ArrayList<>();
              for (String element : elements)
              {
                  listOfDouble.add(Double.parseDouble(element));
              }
              listDouble.put(day,listOfDouble);
          }
        }
        return listDouble;
    }
    public static LinkedHashMap<String, List<Integer>> readFileInt() throws IOException
    {
        LinkedHashMap<String, List<Integer>> listInteger = new LinkedHashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("gruppeneinteilung.txt")))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(";");
                String gruppe = parts[0];
                String[] elements = parts[1].split(",");
                ArrayList<Integer> listOfIntegers = new ArrayList<>();
                for (String element : elements)
                {
                    listOfIntegers.add(Integer.parseInt(element));
                }
                listInteger.put(gruppe,listOfIntegers);
            }

        }
        return listInteger;
    }
    */

}
