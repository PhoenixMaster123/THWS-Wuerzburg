package Klausurvorberaitung.ss2024.Aufgabe4_Piped_Threads;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedWriter;

public class Writer implements Runnable {

    PipedWriter pipedWriter;

    public Writer(PipedWriter pipedWriter) {
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
        try(BufferedWriter writer = new BufferedWriter(pipedWriter)) {
            String message = "Hello World!";
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
