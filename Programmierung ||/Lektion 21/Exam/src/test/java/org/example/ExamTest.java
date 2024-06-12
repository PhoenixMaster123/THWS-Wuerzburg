package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;

class ExamTest {

    //@TempDir Annotation:
    //Used @TempDir to create a temporary directory for test files,
    //ensuring no conflicts with static filenames.
    @TempDir
    Path tempDir;

    @Test
    public void toTest() throws IOException {
        Exam exam = new Exam();
        String[] questionsArray = {"Was besagt das SOLID prinzip?", "Was macht den Projektmanager?"};
        List<Question> questionList = createQuestionList(questionsArray);
        exam.questions.addAll(questionList);

        String expectedResult = "\\documentclass[10pt,a4paper]{article}\n" +
                "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "...\n" +
                "\\begin{document}\n" +
                "\\textbf{Was besagt das SOLID prinzip?}\\\\\n" +
                "\\textbf{Was macht den Projektmanager?}\\\\\n" +
                "\\end{document}";

        Path testFile = tempDir.resolve("test.tex");
        try (BufferedWriter os = new BufferedWriter(new FileWriter(testFile.toFile()))) {
            os.write(exam.readHeaderFromFile());
            os.write("\n\\begin{document}\n");
            for (Question question : questionList) {
                os.write("\\textbf{" + question + "}\\\\\n");
            }
            os.write("\\end{document}");
        }

        StringBuilder builder = new StringBuilder();
        try (BufferedReader ins = new BufferedReader(new FileReader(testFile.toFile()))) {
            String line;
            while ((line = ins.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }

        assertEquals(expectedResult.trim(), builder.toString().trim());
    }

    @Test
    public void readHeaderTest() {
        Exam exam = new Exam();
        String expectedHeader = "\\documentclass[10pt,a4paper]{article}\n" +
                "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "...";
        assertEquals(expectedHeader, exam.readHeaderFromFile());
    }

    @Test
    public void arrayListTest() {
        String[] questionsArray = {"Was besagt das SOLID prinzip?", "Was macht den Projektmanager?"};
        List<Question> questionList = createQuestionList(questionsArray);
        assertEquals(2, questionList.size());
    }

    private List<Question> createQuestionList(String[] questions) {
        List<Question> result = new ArrayList<>();
        for (String question : questions) {
            result.add(new Question(question));
        }
        return result;
    }
}

////////////////////////////////////Variant 2 - My///////////////////////////////////////

// -> the @Test toTest is not working
/*
class ExamTest
{
    @Test
    public void toTest()
    {
        Exam exam = new Exam();
        StringBuilder builder = new StringBuilder();
        String[] questions = {"Was besagt das SOLID prinzip?", "Was macht den Projektmanager?"};
        List<Question> questionList = reduceLogicArrayList(questions);

        String expectedResult = "\\documentclass[10pt,a4paper]{article}\n" +
                "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "...\n" +
                "\\begin{document}\n" +
                "\\textbf{Was besagt das SOLID prinzip?}\\\\\n" +
                "\\textbf{Was macht den Projektmanager?}\\\\\n" +
                "\\end{document}";

        try(StringReader in = new StringReader("test.tex");
            BufferedReader ins = new BufferedReader(in);
            BufferedWriter os = new BufferedWriter(new FileWriter("test.tex")))
        {
            os.write(exam.readHeaderFromFile());
            for (Question question : questionList)
            {
                os.write("\n\\textbf{" + question + "}\\\\\n");
                os.flush();
                os.newLine();
            }
            String line;
            while ((line = ins.readLine()) != null)
            {
                builder.append(line);
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }

        assertEquals(expectedResult,builder.toString());
    }
    @Test
    public void readHeaderTest()
    {
        Exam exam = new Exam();
        String expectedHeader = "\\documentclass[10pt,a4paper]{article}\n"
                + "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n"
                + "\\usepackage[utf8]{inputenc}\n"
                + "...";
        assertEquals(expectedHeader, exam.readHeaderFromFile());
    }
    @Test
    public void arrayListTest()
    {
       String[] questions = {"Was besagt das SOLID prinzip?", "Was macht den Projektmanager?"};
        List<Question> questionList = reduceLogicArrayList(questions);

        assertEquals(2, questionList.size());
    }

    private List<Question> reduceLogicArrayList(String[] questions)
    {
        List<Question> result = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader("questions.csv"));
            BufferedWriter os = new BufferedWriter(new FileWriter("questions.csv")))
        {
            for (String question : questions)
            {
                os.write(question);
                os.flush();
                os.newLine();
            }
            String line;
            while ((line = in.readLine()) != null)
            {
                result.add(Question.toQuestion(line));
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
        return result;
    }
}
 */