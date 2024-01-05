import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int zahl = liesZahl();
        System.out.println("Die eingelesene Zahl ist: " + zahl);
    }

    public static int liesZahl() {
        Scanner scanner = new Scanner(System.in);
        int eingabe = 0;
        boolean correct = false;

        while (!correct) {
            System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
            String zahlString = scanner.nextLine();

            try {
                eingabe = Integer.valueOf(zahlString);
                correct = true;
            } catch (NumberFormatException e) {
                System.out.println("Fehler: Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
            }
        }
        return eingabe;
    }
}
