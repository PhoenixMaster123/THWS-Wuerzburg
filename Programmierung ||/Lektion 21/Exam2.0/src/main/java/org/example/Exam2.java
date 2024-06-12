package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exam2
{
    protected final List<Question> questions = new ArrayList<>();
    private String readHeaderFile()
    {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader("header.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                result.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
        return result.toString();
    }
    public Exam2 readQuestions()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("questions.csv")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                questions.add(Question.toQuestion(line));
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
        return this;
    }
    public void toTest()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt")))
        {
            writer.write(readHeaderFile());
            writer.newLine();
            for (Question question : questions)
            {
                writer.write("\\textbf{" + question.text + "}\\\\");
                writer.newLine();
            }
            writer.write("\\end{document}");
            writer.flush();
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}
