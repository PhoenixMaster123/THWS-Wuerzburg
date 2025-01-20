package Klausurvorberaitung.ss2024.Aufgabe4_Piped_Threads;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Main {
    public static void main(String[] args) {
        try {
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader(pipedWriter); // Connect writer to reader

            Writer writerThread = new Writer(pipedWriter);
            Reader readerThread = new Reader(pipedReader);

            Thread t1 = new Thread(readerThread);
            Thread t2 = new Thread(writerThread);

            t1.start();
            t2.start();

        } catch (IOException e) {
            System.err.println("Error setting up pipes: " + e.getMessage());
        }
    }
}
