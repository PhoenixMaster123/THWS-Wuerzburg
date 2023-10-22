import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int betragt = 1;
        while (true) {
            System.out.print("Geben Sie bitte eine Zahl ein: ");
            int product = sc.nextInt();

            if (product <= 0 || product > 1000000) {
                System.out.println("FEHLER – Zahl ist ungültig");
            } else {
                while (product > 0)
                {
                    int zahl = product % 10;
                    betragt *= zahl;
                    product /= 10;
                }
                System.out.println("Das Querprodukt der Zahl " + product + " betraegt " + betragt);
                break;
            }
        }
    }
}