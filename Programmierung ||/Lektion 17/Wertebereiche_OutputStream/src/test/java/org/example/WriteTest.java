package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WriteTest
{
    @Test
    public void writeTest() throws IOException
    {
        String fileName = "result.txt";

        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            byte[] data = "Hello, World!".getBytes();
            int off = 0;
            int len = data.length;

            outputStream.write(data, off, len);
        }

        // Now we read from the file to verify its contents
        // Wir können BufferedReader oder Scanner -> BufferedReader ist optimized version von Scanner
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            //String line = reader.nextLine();
            String line = reader.readLine();
            assertEquals("Hello, World!", line);
        }
    }
    @Test
    public void writeTestWithNullPointException()
    {
        String fileName = "result.txt";
        //////////////////////////// Variant 1 with Lambda //////////////////////////
        assertThrows(NullPointerException.class, () -> {
            try (OutputStream outputStream = new FileOutputStream(fileName)) {
                byte[] data = null;
                int off = 0;
                int len = data.length;

                outputStream.write(data, off, len);
            }
        });
        //////////////////////////// Variant 2 //////////////////////////
        /*
        try(OutputStream outputStream = new FileOutputStream(fileName))

        {
            byte[] data = null;
            int off = 0;
            int len = data.length;

            outputStream.write(data,off,len);
        }
        catch (NullPointerException e)
        {
            assertTrue(true);
        }

         */
    }
    @Test
    public void writeTestIndexOutOfBoundsException()
    {
        String fileName = "result.txt";

        assertThrows(IndexOutOfBoundsException.class, () ->
        {
            try(OutputStream output = new FileOutputStream(fileName))
            {
                byte[] data = "Hello, World!".getBytes();
                output.write(data, -1, data.length);
            }
        });
    }
    @Test
    public void writeTestWithNegativeLength()
    {
        String fileName = "result.txt";

        assertThrows(IndexOutOfBoundsException.class, () ->
        {
            try(OutputStream output = new FileOutputStream(fileName))
            {
                byte[] data = "Hello, World!".getBytes();
                output.write(new byte[5], 0, -1);
            }
        });
    }

}