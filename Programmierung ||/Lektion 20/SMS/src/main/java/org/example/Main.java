package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


          /*  try (BufferedReader in = new BufferedReader(new FileReader("Zeichenkontakte.txt"));
                 BufferedWriter out = new BufferedWriter(new FileWriter("Nummernkontakte.txt"))) {
                Map<String, String> telefon = buildTelefon();
                buildSMS(telefon, in, out);
            } catch (IOException | IllegalTelephoneNumberException e) {
                System.err.println("Fehler: " + e.getMessage());
            }

           */
    }
}

     /*   public static void buildSMS(Map<String, String> telefon, BufferedReader in, BufferedWriter out) throws IllegalTelephoneNumberException, IOException {
            int c;
            while ((c = in.read()) != -1) {
                char ch = (char) c; // Convert int to char

                if (Character.isUpperCase(ch)) {
                    String digit = telefon.get(String.valueOf(ch));
                    if (digit != null) {
                        out.write(digit);
                    } else {
                        // Skip character if not found in map (invalid)
                        System.err.println("Übersprungen: Ungültiges Zeichen '" + ch + "'");
                    }
                } else {
                    // Skip character if not uppercase letter
                    System.err.println("Übersprungen: Ungültiges Zeichen '" + ch + "'");
                }
                out.flush(); // Flush after each potentially written digit
            }
        }

        public static Map<String, String> buildTelefon()
        {
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

      */