package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Example ThrowingConsumer that throws IOException
        ThrowingConsumer<String, IOException> consumer = s -> {
            if (s == null) {
                throw new IOException("Input string is null");
            }
            System.out.println("Accepted: " + s);
        };

        // Test the ThrowingConsumer
        try {
            consumer.accept("Test String");  // Should print "Accepted: Test String"
            consumer.accept(null);          // Should throw IOException
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }
    }
}