package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Galgamaennchen implements Game
{
    private String word;
    private final char[] hiddenWord;
    private int attempts;
    private boolean running;

    public Galgamaennchen()
    {
        this.word = generateWord();
        this.hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        this.attempts = 15;
        this.running = true;
    }

    @Override
    public String welcome() {
        return "Welcome to the game! Your word is " + String.valueOf(hiddenWord);
    }

    @Override
    public boolean isRunning() {
        return running && attempts > 0  && !isTheWordGuessed(hiddenWord);
    }

    @Override
    public String processUserInput(String userInput) {
        if (userInput.length() != 1) {
            return "Please enter a single character.";
        }

        char letter = userInput.charAt(0);
        String response = handleGuess(letter);

        attempts--;

        if (isTheWordGuessed(hiddenWord)) {
            running = false;
            return "The word is guessed: " + word;
        }

        if (attempts == 0) {
            running = false;
            return "No attempts left. The word was: " + word;
        }
        return response + " " + String.valueOf(hiddenWord) + " (Attempts left: " + attempts + ")";
    }

    private String handleGuess(char guess) {
        if (word.indexOf(guess) >= 0) {
            updateTheWord(word, guess, hiddenWord);
            return "Correct!";
        } else {
            return "Incorrect!";
        }
    }

    private boolean isTheWordGuessed(char[] arr) {
        for (char c : arr) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private void updateTheWord(String word, char guess, char[] hiddenWord) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                hiddenWord[i] = guess;
            }
        }
        System.out.println(String.valueOf(hiddenWord));
    }

    private String generateWord() {
        List<String> words = Arrays.asList("programmieren", "netzwerk", "geschwindigkeit",
                "landschaft", "sonnenuntergang", "wanderung", "zusammensein", "freiheit", "hoffnung");
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toLowerCase();
    }

    public String getWord() {
        return word;
    }
}
