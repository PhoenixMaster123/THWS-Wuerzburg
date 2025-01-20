package Klausurvorberaitung.ss2024.Aufgabe4_Piped_Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class Reader implements Runnable {

    PipedReader pipedReader;

    public Reader(PipedReader pipedReader) {
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(pipedReader)) {
            String message = reader.readLine();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
