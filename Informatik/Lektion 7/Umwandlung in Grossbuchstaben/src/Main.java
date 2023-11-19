import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(Großbuchstaben(text));
    }

    private static String Großbuchstaben(String text)
    {
        char[] letters = text.toCharArray();

        for (int i = 0; i < letters.length; i++)
        {
            if(letters[i] >= 97 && letters[i] <= 122)
            {
                int code = letters[i];
                int gross = code - 32;
                char newLetter = (char) gross;
                letters[i] = newLetter;
            }
        }
        return String.valueOf(letters);
    }
}