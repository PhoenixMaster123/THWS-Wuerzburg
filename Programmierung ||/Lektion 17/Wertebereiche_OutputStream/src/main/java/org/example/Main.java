package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try(InputStream input = new FileInputStream("text.txt");
            OutputStream output = new FileOutputStream("result.txt");)
        {
            print(input,output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void write(byte[] b, int off, int len)
    {
        try(OutputStream os = new FileOutputStream("text.txt"))
        {
            os.write(b,off,len);
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }

    }

    private static void print(InputStream input, OutputStream output) throws IOException
    {
        byte[] b = new byte[5];
        int n;
        do {
            n = input.read(b); // kann maximal 5 bytes read
            if(n != -1)
            {
                output.write(b,0,n);
            }
        }
        while (n != -1);
    }
}