package org.example;

public class GameTicTacToe implements Game
{
    @Override
    public String welcomeString() {
        return "Welcome to the game Tic Tac Toe";
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
