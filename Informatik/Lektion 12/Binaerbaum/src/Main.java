import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Baum dictionaryTree = new Baum();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do
        {
            System.out.println("\nMenu:");
            System.out.println("1. Insert into dictionary");
            System.out.println("2. Search in dictionary");
            System.out.println("3. Delete from dictionary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice)
            {
                case 1:
                    System.out.print("Enter word: ");
                    String word = scanner.nextLine();
                    System.out.print("Enter meaning: ");
                    String meaning = scanner.nextLine();

                    Knoten newEntry = new Knoten(word, meaning);
                    dictionaryTree.Insert(newEntry);

                    System.out.println("Dictionary after insertion:");
                    dictionaryTree.Print();
                    break;

                case 2:
                    System.out.print("Enter word to search: ");
                    String searchWord = scanner.nextLine();
                    String result = dictionaryTree.search(searchWord);

                    if (result != null)
                    {
                        System.out.println("Meaning: " + result);
                    }
                    else
                    {
                        System.out.println("Word not found in the dictionary.");
                    }
                    break;

                case 3:
                    // Optional: Implement deletion
                    System.out.print("Enter word to delete: ");
                    String deleteWord = scanner.nextLine();
                    // Call your delete method here
                    // dictionaryTree.delete(new Knoten(deleteWord, null));
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}