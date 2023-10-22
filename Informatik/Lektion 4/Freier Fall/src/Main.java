import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sekunden = Integer.parseInt(sc.nextLine());
        double g = 9.80665;
        for (int i = 1; i <= sekunden; i++)
        {
            double formel = (0.5) * g * i * i;
            System.out.printf("Zeit: %d Sekunden: Zurückgelegte Strecke: %f m\n", i, formel);
        }
    }
}