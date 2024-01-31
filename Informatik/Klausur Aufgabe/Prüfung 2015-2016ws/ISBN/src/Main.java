import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
            ISBN isbn = new ISBN();
            boolean isValidISBN = isbn.validateISBN(number);

        if (isValidISBN) {
            System.out.println("Die eingegebene ISBN ist gültig.");
        } else {
            System.out.println("Die eingegebene ISBN ist ungültig.");
        }

        }
    }
