package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ToDO -> ich brauche Datei
        String sourcePath = "";
        try {
            System.out.println("Enter source file path:");
            sourcePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
            // Without Buffer
            long startTimeUnbuffered = System.nanoTime();
            fileCopyWithoutBuffer(sourcePath, "testWithoutBuffer.mp3");
            long endTimeUnbuffered = System.nanoTime();
            long durationUnbuffered = endTimeUnbuffered - startTimeUnbuffered;
            System.out.println("Time taken without buffer: " + durationUnbuffered + " ns");


            // With Buffer
            long startTimeBuffered = System.nanoTime();
            fileCopyWithBuffer(sourcePath, "testWithBuffer.mp3");
            long endTimeBuffered = System.nanoTime();
            long durationBuffered = endTimeBuffered - startTimeBuffered;
            System.out.println("Time taken with buffer: " + durationBuffered + " ns");

            // Without Buffer but with byte[]
            long startTimeUnbufferedArray = System.nanoTime();
            copyFileUnbufferedWithArray(sourcePath, "testWithArray.mp3");
            long endTimeUnbufferedArray = System.nanoTime();
            long durationUnbufferedArray = endTimeUnbufferedArray - startTimeUnbufferedArray;
            System.out.println("Zeit für ungepufferten Stream mit byte[]: " + durationUnbufferedArray + " ns");

            // Length prüfen
            /////////////////////////////////// Variant 1 ////////////////////
            checkFileLength("testWithoutBuffer.mp3", "testWithoutBuffer.mp3", "testWithArray.mp3");
            /////////////////////////////////// Variant 2 ////////////////////
            //String[] filesToCheck = {"test_unbuffered.mp3", "test_buffered.mp3", "test_unbuffered_array.mp3"};
           // checkFileLength2(filesToCheck);
    }

    /////////////////////////////////// Variant 1 //////////////////////////////////////////
    private static void checkFileLength(String... fileName)
    {
        for (String name : fileName)
        {
            File file = new File(name);
            System.out.println("Datei " + name + " hat eine Länge von " + file.length() + " Bytes.");
        }
    }

    /////////////////////////////////// Variant 2 ///////////////////////////////////////////////
    /*
    private static void checkFileLength2(String[] fileName)

    {
        for (String name : fileName)
        {
            File file = new File(name);
            System.out.println("Datei " + name + " hat eine Länge von " + file.length() + " Bytes.");
        }
    }
     */


    private static void copyFileUnbufferedWithArray(String sourcePath, String destPath) // erste
    {
        try(FileInputStream input = new FileInputStream(sourcePath);
            FileOutputStream output = new FileOutputStream(destPath))
        {
            File file = new File(sourcePath);
            if(!file.exists())
            {
                throw new FileNotFoundException();
            }
            //byte[] bytes = new byte[1024];

            int n;
            do {
                n = input.read();
                if (n != -1) {
                    output.write(n);
                }
            }
            while (n != -1);
        }
        catch (IOException e)
        {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
            e.getStackTrace();
        }
    }

    public static void fileCopyWithoutBuffer(String sourcePath, String destPath) // letzte
    {
        try (FileInputStream input = new FileInputStream(sourcePath);
             FileOutputStream output = new FileOutputStream(destPath))
        {
            File file1 = new File(sourcePath);
            if(!file1.exists())
            {
                throw new FileNotFoundException();
            }
            byte[] file = new byte[1024];
            int byteRead;
            while ((byteRead = input.read(file)) != -1)
            {
                output.write(file, 0, byteRead);
            }
        }
        catch (IOException e)
        {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
            e.getStackTrace();
        }
    }
    public static void fileCopyWithBuffer(String sourcePath, String destPath) // zweite
    {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(destPath)))
        {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file not found: " + sourcePath);
            }
           // byte[] buffer = new byte[1024];
            int byteRead;
            while ((byteRead = input.read()) != -1)
            {
                output.write(byteRead);
            }
        }
        catch (IOException e)
        {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
            e.getStackTrace();
        }

    }
}


///////////////////////////////// Variant 2 //////////////////////////////
/*
public class Main {
    public static void main(String[] args) {
        // Benutzer eingabe für Dateipfad
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie den Pfad zur Musikdatei ein:");
        String sourcePath = "";
        try {
            sourcePath = reader.readLine();
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen des Dateipfads: " + e.getMessage());
            System.exit(1);
        }

        // Ungepuffertes Stream Kopieren
        long startTimeUnbuffered = System.currentTimeMillis();
        copyFileUnbuffered(sourcePath, "test_unbuffered.mp3");
        long endTimeUnbuffered = System.currentTimeMillis();
        long durationUnbuffered = endTimeUnbuffered - startTimeUnbuffered;
        System.out.println("Zeit für ungepufferten Stream: " + durationUnbuffered + " ms");

        // Gepuffertes Stream Kopieren
        long startTimeBuffered = System.currentTimeMillis();
        copyFileBuffered(sourcePath, "test_buffered.mp3");
        long endTimeBuffered = System.currentTimeMillis();
        long durationBuffered = endTimeBuffered - startTimeBuffered;
        System.out.println("Zeit für gepufferten Stream: " + durationBuffered + " ms");

        // Ungepuffertes Stream Kopieren mit byte[]
        long startTimeUnbufferedArray = System.currentTimeMillis();
        copyFileUnbufferedWithArray(sourcePath, "test_unbuffered_array.mp3");
        long endTimeUnbufferedArray = System.currentTimeMillis();
        long durationUnbufferedArray = endTimeUnbufferedArray - startTimeUnbufferedArray;
        System.out.println("Zeit für ungepufferten Stream mit byte[]: " + durationUnbufferedArray + " ms");

        // Überprüfen der Dateilänge
        checkFileLength("test_unbuffered.mp3", "test_buffered.mp3", "test_unbuffered_array.mp3");
    }

    private static void copyFileUnbuffered(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
        }
    }

    private static void copyFileBuffered(String sourcePath, String destPath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {
            int byteRead;
            while ((byteRead = bis.read()) != -1) {
                bos.write(byteRead);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
        }
    }

    private static void copyFileUnbufferedWithArray(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
        }
    }

    private static void checkFileLength(String... fileNames) {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            System.out.println("Datei " + fileName + " hat eine Länge von " + file.length() + " Bytes.");
        }
    }
}
 */

