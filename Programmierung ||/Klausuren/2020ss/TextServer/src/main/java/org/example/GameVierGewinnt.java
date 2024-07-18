package org.example;

public class GameVierGewinnt implements Game
{
    public String welcomeString()
    {
        return "Welcome to the game Vier Gewinnt!";
    }

    @Override
    public boolean running() {
        return false;
    }

    @Override
    public String handleInput(String line) {
        return null;
    }

    @Override
    public void reset() {

    }

}
