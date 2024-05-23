package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Galgamaennchen implements Game
{
    String word = generateWord();
    char[] hiddenWord;
    int attempts;

    public Galgamaennchen()
    {
        this.hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        attempts = 15;
    }

    @Override
    public String welcome() {
        return "Welcome to the game! Your word is: " + String.valueOf(hiddenWord);
    }

    @Override
    public boolean isRunning() {
       return attempts > 0 && !isTheWordGuessed();
    }

    @Override
    public String processUserInput(String userInput)
    {
        if(userInput.length() != 1)
        {
           return "Please enter single character!";
        }
        char guess = userInput.charAt(0);
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
    private String generateWord()
    {
        List<String> words = Arrays.asList("programmieren", "netzwerk", "geschwindigkeit",
                "landschaft", "sonnenuntergang", "wanderung", "zusammensein", "freiheit", "hoffnung");
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toUpperCase();
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
    public String getWord() {
        return word;
    }
}
