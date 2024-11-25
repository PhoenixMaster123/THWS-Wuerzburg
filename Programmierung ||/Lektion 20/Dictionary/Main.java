package Lektion20.Dictionary;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new TreeMap<>();

        while (true) {
            System.out.println("Enter English word (or type 'exit' to stop):");
            String englishWord = scanner.nextLine();
            if (englishWord.equalsIgnoreCase("exit")) break;

            System.out.println("Enter German translation:");
            String germanWord = scanner.nextLine();

            dictionary.computeIfAbsent(englishWord, k -> new LinkedList<>()).add(germanWord);
        }
    }
}
