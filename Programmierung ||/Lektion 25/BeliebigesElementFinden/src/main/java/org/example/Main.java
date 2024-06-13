package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException
    {

        System.out.println(readFileWithFindAny());
        System.out.println(readFileWithAnyMatch());

        /*Optional<String> lastElement = list.stream()
                .skip(list.size() - 1)
                .findAny();
         */

    }

    private static boolean readFileWithFindAny() throws IOException
    {
        boolean check = false;
        try(BufferedReader reader = new BufferedReader(new FileReader("farben.csv")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(";");
                List<String> list = Arrays.stream(parts).toList();
                Optional<String> result = list.stream().filter(e -> e.endsWith("x")).findAny();
                boolean isElementThere = result.isPresent() && result.get().endsWith("x");
                if(isElementThere)
                {
                    check = true;
                }
                else
                {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    public static boolean readFileWithAnyMatch() throws IOException
    {
        boolean result = false;
        try(BufferedReader reader = new BufferedReader(new FileReader("farben.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                List<String> list = Arrays.stream(parts).toList();
                result = list.stream().anyMatch(e -> e.endsWith("x"));
               if(result)
               {
                   continue;
               }
               else
               {
                   return result;
               }
            }
        }
        return result;
    }
}