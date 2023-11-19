import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        char[] letters = text.toCharArray();
        int counter = 0;

        // Count the number of vowels to determine the size of the new array
        for (int i = 0; i < letters.length; i++) {
            if (isVowel(letters[i])) {
                counter+= 2;
            }
        }
        // 
        char[] arr = new char[text.length() + counter];
        String word = spiel(letters, arr);
        System.out.println(word);
    }

    private static String spiel(char[] letters, char[] arr)
    {
        int index = 0;
        for (int i = 0; i < letters.length; i++) {
            arr[index++] = letters[i];

            if (isVowel(letters[i])) {
                arr[index++] = 'b';
                arr[index++] = letters[i];
            }
        }
        return String.valueOf(arr);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
