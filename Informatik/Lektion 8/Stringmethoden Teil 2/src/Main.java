import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String sentence = "  Ich gehe morgen mit meinen 11 Freund*innen zum Essen!   ";
        
        System.out.println(deleteStartingSpace(sentence));
        System.out.println(deleteEndingSpace(sentence));
        System.out.println(deleteMultipleSpace(sentence));

        String[] result = splitAtSpace(sentence);

        for (String part : result)
        {
            System.out.println(part);
        }
    }

    public static String[] splitAtSpace(String input)
    {
        ////////////////////////////////////// Variant 1 ////////////////////
        // Verwenden Sie die split-Methode mit Leerzeichen als Trennzeichen
        return input.split(" ");
        ////////////////////////////////////// Variant 2 ////////////////////
        /*
         String[] parts = new String[spaceCount + 1];

        // Start-Index für einen Teilstring
        int startIndex = 0;

        // Aktueller Index im Array
        int currentIndex = 0;

        // Durchlaufen des Eingabestrings
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Überprüfen, ob das aktuelle Zeichen ein Leerzeichen ist
            if (currentChar == ' ') {
                // Extrahieren des Teilstrings und zum Array hinzufügen
                parts[currentIndex++] = input.substring(startIndex, i);

                // Aktualisieren des Start-Index für den nächsten Teilstring
                startIndex = i + 1;
            }
        }

        // Extrahieren des letzten Teilstrings (nach dem letzten Leerzeichen)
        parts[currentIndex] = input.substring(startIndex);

        return parts;
         */
    }
    public static String deleteMultipleSpace(String sentence)
    {
        ////////////////////////////////////// Variant 1 ///////////////////////
        String deleteMultipleSpaces = sentence.replaceAll("\\s+", " ");
        return deleteMultipleSpaces.trim();
        ///////////////////////////////////// Variant 2 ///////////////////////
        /*
          String result = "";

        // Flag to track if the last character was a space
        boolean lastCharWasSpace = false;

        for (char ch : sentence.toCharArray()) {
            if (ch == ' ') {
                // If the last character was not a space, append it to the result
                if (!lastCharWasSpace) {
                    result += ch;
                }
                lastCharWasSpace = true;
            } else {
                // If the current character is not a space, append it to the result
                result += ch;
                lastCharWasSpace = false;
            }
         */
    }

    public static String deleteEndingSpace(String sentence)
    {
        char[] ch = sentence.toCharArray();

        // Find the index of the first non-space character
        int startIndex = 0;
        for (int i = 0; i < ch.length; i++)
        {
            if (ch[i] != ' ')
            {
                startIndex = i;
                break;
            }
        }

        // Find the index of the last non-space character
        int endIndex = ch.length - 1;
        for (int i = ch.length - 1; i >= 0; i--)
        {
            if (ch[i] != ' ')
            {
                endIndex = i;
                break;
            }
        }

        // Use substring to exclude trailing spaces
        return sentence.substring(startIndex, endIndex + 1);

        /////////////////////////// While Schleife /////////////////////
        /*
         char[] ch = sentence.toCharArray();

    // Find the index of the first non-space character
    int startIndex = 0;
    while (startIndex < ch.length && ch[startIndex] == ' ')
    {
        startIndex++;
    }

    // Find the index of the last non-space character
    int endIndex = ch.length - 1;
    while (endIndex >= 0 && ch[endIndex] == ' ')
    {
        endIndex--;
    }

    // Use substring to exclude trailing spaces
    return sentence.substring(startIndex, endIndex + 1);
         */
    }

    public static String deleteStartingSpace(String sentence)
    {
        int startIndex = 0;

        // Find the index of the first non-space character
        while (startIndex < sentence.length() && sentence.charAt(startIndex) == ' ')
        {
            startIndex++;
        }

        // Use the substring starting from the first non-space character
        return sentence.substring(startIndex);
    }
}