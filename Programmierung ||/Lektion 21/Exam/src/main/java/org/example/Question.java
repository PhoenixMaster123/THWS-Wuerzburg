package org.example;

public class Question
{
    String text;
    //Wandelt eine eingelesene Zeile in ein Question-Objekt um
    public Question(String text)
    {
        this.text = text;
    }
    public static Question toQuestion(String line)
    {
       return new Question(line);
    }

    @Override
    public String toString() {
        return text;
    }
}
