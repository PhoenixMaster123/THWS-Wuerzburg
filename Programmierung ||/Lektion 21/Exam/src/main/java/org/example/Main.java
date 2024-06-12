package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Exam exam = new Exam();
            exam.readQuestions();
            exam.toTest();
            System.out.println("Exam was successfully created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}