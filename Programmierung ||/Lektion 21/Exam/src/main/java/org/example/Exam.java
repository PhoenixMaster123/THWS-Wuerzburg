package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    List<Question> questions = new ArrayList<>();

    // Liest die Fragen aus der Datei "questions.csv" und speichert sie im Exam-Objekt
    public void readQuestions() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("questions.csv"))) {
            String line;
            while ((line = in.readLine()) != null) {
                Question question = Question.toQuestion(line);
                questions.add(question);
            }
        }
    }

    // Schreibt den Inhalt und die Fragen in eine LaTeX-Datei "test.tex"
    public void toTest() throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("test.tex"))) {
            // Zuerst den Header schreiben
            String header = readHeaderFromFile();
            out.write(header);
            out.write("\n\\begin{document}\n");

            // Dann jede Frage im angegebenen Format schreiben
            for (Question question : questions) {
                out.write("\\textbf{" + question.text + "}\\\\\n");
            }

            // Abschließend den Dokumenten-Ende-Tag schreiben
            out.write("\\end{document}");
        }
    }

    // Beispielmethode zur Veranschaulichung des Header-Lesens, Rückgabe eines statischen Strings
    String readHeaderFromFile() {
        return "\\documentclass[10pt,a4paper]{article}\n"
                + "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n"
                + "\\usepackage[utf8]{inputenc}\n"
                + "...";
    }
}
