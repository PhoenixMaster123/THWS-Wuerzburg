import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib mir ein Wort: ");
        String sentence = scanner.nextLine().toUpperCase();
        char[] word = sentence.toCharArray();
        char[] letters = sentence.toCharArray();
        int numeric = 1;
        boolean t = false;
        for (int i = 0; i < letters.length; i++)
        {
            letters[i] = '_';
        }

        for (int i = 0; i < 15; i++)
        {
            System.out.print(numeric + ". Versuch: ");
            System.out.print(letters);
            System.out.println();
            char buchstabe = scanner.nextLine().toUpperCase().charAt(0);
            System.out.println("Buchstabe: " + buchstabe);

            for (int j = 0; j < letters.length; j++)
            {
                if(word[j] == buchstabe)
                {
                    letters[j] = buchstabe;
                }
                for (int k = 0; k < word.length; k++) {

                    if(letters[k] !=  '_')
                    {
                        t = true;
                    }
                    else
                    {
                        t = false;
                        break;
                    }
                }
            }
            if(t)
            {
                break;
            }
            numeric++;

        }
        if(t)
        {
            System.out.println("Das Wort ist voll.");
            System.out.println(letters);
        }
        else
        {
            System.out.println("Das Wort ist nicht voll und du hast keine mehrere Versuche.");
        }
    }
}