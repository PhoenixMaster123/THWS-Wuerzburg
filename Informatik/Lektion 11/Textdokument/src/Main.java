import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] textdokument = new char[][]
        {
                {'H', 'E', 'L', 'L', 'O'},
                {'W', 'O', 'R', 'D'},
                {'T', 'E', 'S', 'T'}
        };


        //int leerZeichnen = zaehleZeichen(textdokument);
        //System.out.println(leerZeichnen);

        boolean erfolgreichVertauscht = vertauscheZeilen(textdokument, 0, 2);

        if (erfolgreichVertauscht) {
            System.out.println("Nach dem Vertauschen:");
            for (int i = 0; i < textdokument.length; i++) {
                for (int j = 0; j < textdokument[i].length; j++)
                {
                    System.out.print(textdokument[i][j]);
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Vertauschen fehlgeschlagen. Mindestens eine Zeilenposition liegt außerhalb des Textdokuments.");
        }

        char[][] einzufuegendesDokument = new char[][]
                {
                        {'A', 'B', 'C'},
                        {'X', 'Y', 'Z'}
                };

        int zeilenPosition = 1;

        try {
            fuegeEinTextdokument(textdokument, einzufuegendesDokument, zeilenPosition);
            for (int i = 0; i < textdokument.length; i++) {
                for (int j = 0; j < textdokument[i].length; j++)
                {
                    System.out.print(textdokument[i][j]);
                }
                System.out.println();
            }
        } catch (RuntimeException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    private static void fuegeEinTextdokument(char[][] textdokument, char[][] einzufuegendesDokument, int zeilenPosition) {
        if (zeilenPosition < 0 || zeilenPosition > textdokument.length) {
            throw new RuntimeException("Ungültige Zeilenposition");
        }

        // Erstelle ein neues Array, um das vergrößerte Textdokument zu speichern
        char[][] neuesTextdokument = new char[textdokument.length + einzufuegendesDokument.length][];

        // Kopiere die Zeilen vor der Einfügeposition
        for (int i = 0; i < zeilenPosition; i++) {
            neuesTextdokument[i] = textdokument[i];
        }

        // Füge das einzufügende Textdokument ein
        for (int i = 0; i < einzufuegendesDokument.length; i++) {
            neuesTextdokument[zeilenPosition + i] = einzufuegendesDokument[i];
        }

        // Kopiere die Zeilen nach der Einfügeposition
        for (int i = zeilenPosition; i < textdokument.length; i++) {
            neuesTextdokument[i + einzufuegendesDokument.length] = textdokument[i];
        }

        // Aktualisiere das Originaltextdokument
        for (int i = 0; i < neuesTextdokument.length; i++) {
            textdokument[i] = neuesTextdokument[i];
        }
    }

    private static boolean vertauscheZeilen(char[][] textdokument, int zeilenPosition1, int zeilenPosition2) {
        if (zeilenPosition1 < 0 || zeilenPosition1 >= textdokument.length || zeilenPosition2 < 0 || zeilenPosition2 >= textdokument.length) {
            return false; // Mindestens eine der beiden Zeilenpositionen liegt außerhalb des Textdokuments
        }

        char[] temp = textdokument[zeilenPosition1];
        textdokument[zeilenPosition1] = textdokument[zeilenPosition2];
        textdokument[zeilenPosition2] = temp;

        return true;
    }

    private static int zaehleZeichen(char[][] symbols) {
        int leerzeichen = 0;

        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < symbols[i].length; j++) {
                if (symbols[i][j] != ' ') {
                    leerzeichen++;
                }
            }
        }
        return leerzeichen;
    }
}

