package _07_Verschlüsselungsalgorithmus._07a;

import java.util.*;

public class Main {
    private static final Map<Integer, Character> alphabetInteger = new HashMap<>();
    private static final Map<Character, Integer> alphabet = new LinkedHashMap<>();

    static {
        alphabetInteger.put(0, ' ');
        alphabet.put(' ', 0);
        for (int i = 1; i <= 26; i++) {
            char c = (char) ('A' + i - 1);
            alphabetInteger.put(i, c);
            alphabet.put(c, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalText = scanner.nextLine().toUpperCase();
        String password = scanner.nextLine().toUpperCase();

        List<Character> listOriginal = new LinkedList<>();
        List<Character> listPassword = new LinkedList<>();

        for (char c : originalText.toCharArray()) {
            listOriginal.add(c);
        }
        int counter = 0;

        while (counter != listOriginal.size()) {

            for (char c : password.toCharArray()) {
                if(counter == listOriginal.size()) {
                    break;
                }
                listPassword.add(c);
                counter++;

            }
        }

        String encryption = encryptText(listOriginal, listPassword);
        System.out.println(encryption);
        System.out.println(decryptText(encryption, listPassword));
    }

    private static String encryptText(List<Character> listOriginal, List<Character> listPassword) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listOriginal.size(); i++) {

            char getOriginal = listOriginal.get(i);
            char getPassword = listPassword.get(i);

            int posOriginal = alphabet.get(getOriginal);
            int posPassword = alphabet.get(getPassword);

            int sum = (posOriginal + posPassword) % 26;

            char result = alphabetInteger.get(sum);
            sb.append(result);
        }
        return sb.toString();
    }
    private static String decryptText(String encryptedText, List<Character> listPassword) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {

            char encryptedChar = encryptedText.charAt(i);
            char passwordChar = listPassword.get(i);


            int posEncrypted = alphabet.get(encryptedChar);
            int posPassword = alphabet.get(passwordChar);

            int decryptedPosition = (posEncrypted - posPassword + 26) % 26;

            char result = alphabetInteger.get(decryptedPosition);
            sb.append(result);
        }
        return sb.toString();
    }

}
