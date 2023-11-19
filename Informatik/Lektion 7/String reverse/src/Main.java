import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        System.out.println(Reverse(text));
    }

    private static String Reverse(String text)
    {
        int counter = 0;
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++)
        {
            char firstLetter = letters[i];
            char lastLetter = letters[letters.length-i-1];
            char trim = firstLetter;
            firstLetter = lastLetter;
            letters[i] = firstLetter;
            lastLetter = trim;
            letters[letters.length-i-1] = lastLetter;
            counter++;
            if(counter == letters.length / 2)
            {
                break;
            }
        }
        return String.valueOf(letters);
    }
}