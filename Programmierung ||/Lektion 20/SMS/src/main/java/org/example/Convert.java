package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Convert {

    public static void translate(Map<String, String> telefon, BufferedReader in, BufferedWriter out) throws IOException {
        int c;
        while ((c = in.read()) != -1) {
            char ch = (char) c; // Convert int to char
            try {
                if (Character.isUpperCase(ch)) {
                    String digit = telefon.get(String.valueOf(ch));
                    if (digit != null) {
                        out.write(digit);
                    } else {
                        // Skip character if not found in map (invalid)
                        System.err.println("Skipped: Invalid character '" + ch + "'");
                    }
                } else {
                    // Skip character if not uppercase letter
                    throw new IllegalTelephoneNumberException(ch);
                }
            } catch (IllegalTelephoneNumberException e) {
                System.err.println(e.getMessage());
            }
            out.flush(); // Flush after each potentially written digit
        }
    }

    public static Map<String, String> buildTelefon() {
        Map<String, String> table = new HashMap<>();
        String[] groups = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        for (int i = 0; i < groups.length; i++) {
            String letters = groups[i];
            for (char letter : letters.toCharArray()) {
                table.put(String.valueOf(letter), String.valueOf(i + 2));
            }
        }
        return table;
    }
}
