package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameGalgenmaennchen implements Game
{
    String word = generateWord();

    private String generateWord()
    {
        List<String> words = Arrays.asList("programmieren", "netzwerk", "geschwindigkeit",
                "landschaft", "sonnenuntergang", "wanderung", "zusammensein", "freiheit", "hoffnung");
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toUpperCase();
    }
    public GameGalgenmaennchen()
    {
        this.hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        attempts = 15;
    }

    char[] hiddenWord;
    int attempts;

    public void reset() {
    }

    public String initGameString()
    {
         return null;
    }

    public String welcomeString()
    {
        return "Welcome to the game Hangman! Your word is " + String.valueOf(hiddenWord);
    }

    public String handleInput(String line)
    {
        if(line.length() != 1)
        {
            return "You need to type single character";
        }
        char guess = line.charAt(0);
        updateTheWord(guess);
        attempts--;

        if(isTheWordGuessed())
        {
            return "The word is guessed: " + word;
        }
        if(attempts == 0)
        {
            return "No more attempts left. The word was: " + word;
        }

        return String.valueOf(hiddenWord) + " (Attempts left: " + attempts + ")";

    }

    private void updateTheWord(char guess)
    {
        for (int i = 0; i < word.length(); i++)
        {
            if(Character.toUpperCase(guess) == word.charAt(i))
            //guess == Character.toLowerCase(word.charAt(i)))
            {
                hiddenWord[i] = Character.toUpperCase(guess);
            }
        }
        System.out.println(String.valueOf(hiddenWord));
    }

    public boolean running()
    {
        return attempts > 0 && !isTheWordGuessed();
    }

    private boolean isTheWordGuessed()
    {
            for (char c : hiddenWord)
            {
                if(c == '_')
                {
                    return false;
                }
            }
            return true;
    }
}
