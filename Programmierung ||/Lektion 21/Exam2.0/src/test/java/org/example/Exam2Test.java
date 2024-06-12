package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Exam2Test
{
    @Test
    public void testAll()
    {
        Exam2 exam = new Exam2();
        exam.readQuestions();
        assertTrue(new File("test.tex").exists());
    }
}