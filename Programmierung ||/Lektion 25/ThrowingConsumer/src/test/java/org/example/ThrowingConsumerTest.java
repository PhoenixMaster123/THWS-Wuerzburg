package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ThrowingConsumerTest {

    // ThrowingConsumer that throws IOException for null input
    ThrowingConsumer<String, IOException> consumer = s -> {
        if (s == null) {
            throw new IOException("Input string is null");
        }
        System.out.println("Accepted: " + s);
    };

    @Test
    void testThrowingConsumer_ValidInput() {
        // Test with valid input
        assertDoesNotThrow(() -> consumer.accept("Test String"));
    }

    @Test
    void testThrowingConsumer_InvalidInput() {
        // Test with null input, expecting IOException
        IOException thrown = assertThrows(IOException.class, () -> consumer.accept(null));
        assertEquals("Input string is null", thrown.getMessage());
    }
}