package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exam implements Read,ToTest
{
    List<String> questions;

    private Exam(){}
    public static Read of()
    {
        Exam exam = new Exam();
        return exam;
    }
    @Override
    public ToTest readQuestions() {
        questions = new ArrayList<>();
        return this;
    }

    @Override
    public void toTest() {

    }
}
