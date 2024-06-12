package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest
{
    @Test
    public void KonstruktorTest()
    {
        Question question = new Question("Was macht den Projektmanager?");
        assertEquals("Was macht den Projektmanager?", question.text);
    }
    @Test
    public void toQuestionTest()
    {
        String line = "Was besagt das SOLID prinzip?";
        Question question = Question.toQuestion(line);
        assertEquals(String.valueOf(question), line);
    }
}