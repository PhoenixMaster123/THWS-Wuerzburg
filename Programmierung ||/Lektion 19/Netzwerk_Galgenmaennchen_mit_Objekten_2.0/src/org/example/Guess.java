package org.example;

import java.io.Serializable;

public class Guess implements Serializable
{
    char guess;
    public Guess(char guess)
    {
        this.guess = guess;
    }
    public String toString()
    {
        return String.valueOf(guess);
    }
}