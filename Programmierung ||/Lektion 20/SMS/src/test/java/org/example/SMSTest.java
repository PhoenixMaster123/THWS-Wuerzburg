package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SMSTest {

    Map<String, String> telefon;

    @BeforeEach
    public void prepareTests() {
        telefon = Convert.buildTelefon();
    }

    @Test
    public void buildTelefonTest() {
        assertEquals("2", telefon.get("A"));
        assertEquals("7", telefon.get("S"));
        assertEquals("9", telefon.get("Z"));
    }

    @Test
    public void testFunctionality1() throws IOException {
        String word = "INFORMATIK";
        methodForStartTheWord(word);
        String result = processSMS();
        assertEquals("4636762845", result);
    }

    @Test
    public void testFunctionality2() throws IOException {
        String word = "PROGRAMMING";
        methodForStartTheWord(word);
        String result = processSMS();
        assertEquals("77647266464", result);
    }

    @Test
    public void testFunctionality3() throws IOException {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        methodForStartTheWord(word);
        String result = processSMS();
        assertEquals("22233344455566677778889999", result);
    }

    @Test
    public void emptyStringTest() throws IOException {
        String word = "";
        methodForStartTheWord(word);
        String result = processSMS();
        assertEquals("", result);
    }

    @Test
    public void illegalCharacter() throws IOException {
        String word = "+ATT+";
        methodForStartTheWord(word);
        String result = processSMS();
        assertEquals("288", result);
    }

    private void methodForStartTheWord(String word) {
        try (FileWriter wr = new FileWriter("Zeichenkontakte.txt")) {
            if (word != null) {
                wr.write(word);
            }
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processSMS() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Zeichenkontakte.txt"));
             StringWriter outputWriter = new StringWriter();
             BufferedWriter writer = new BufferedWriter(outputWriter)) {
            Convert.translate(telefon, reader, writer);
            return outputWriter.toString();
        }
    }
}
