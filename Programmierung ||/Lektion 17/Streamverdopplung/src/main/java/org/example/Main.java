package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        try(FileOutputStream file1 = new FileOutputStream("file1.txt");
            FileOutputStream file2 = new FileOutputStream("file2.txt"))
        {
            OutputStreamDoubler streamDoubler = new OutputStreamDoubler(file1, file2);
            streamDoubler.write(5);
            streamDoubler.close();
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}