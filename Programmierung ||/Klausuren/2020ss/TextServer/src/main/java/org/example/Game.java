package org.example;

public interface Game
{
    String welcomeString();
    boolean running();
    String handleInput(String line);
    void reset();
}
