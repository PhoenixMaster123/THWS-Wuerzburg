package Klausurvorberaitung.ss2020.Aufgabe2;

public interface Game {
    boolean running();
    String handleInput(String line);
    String welcomeString();
    String initGameString();
    void reset();
}
