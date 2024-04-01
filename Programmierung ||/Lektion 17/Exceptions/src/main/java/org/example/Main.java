package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try {
            // a) NumberFormatException
            String eingabe = "2a";
            int zahl = readNumber(eingabe);
        }
        catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe: " + e.getMessage());
        }

        try {
            // b) ArrayIndexOutOfBoundsException
            int[] arr = {1, 2, 3};
            int value = arr[3];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index/Element out of Bounds: " + e.getMessage());
        }

        try {
            // c) NullPointerException
            String str = null;
            int length = str.length();
        }
        catch (NullPointerException e) {
            System.out.println("Auf null referenziert: " + e.getMessage());
        }

        try {
            // d) OutOfMemoryError
            int[] arr2 = new int[Integer.MAX_VALUE];
        }
        catch (OutOfMemoryError error) {
            System.out.println("Out of memory: " + error.getMessage());
        }

        try {
            // e) FileNotFoundException
            File file = new File("not_file.txt");
            Scanner scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + e.getMessage());
        }

        try {
            // f) ArithmeticException
            int result = 15 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println("Division durch Null: " + e.getMessage());
        }
    }

    private static int readNumber(String eingabe) throws NumberFormatException
    {
        return Integer.parseInt(eingabe);
    }
}

