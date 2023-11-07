import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double zahl = scanner.nextDouble();
        if(zahl + 0.5 > zahl)
        {
            System.out.println((int) (zahl + 0.5));
        }
        else
        {
            System.out.println((int) zahl);
        }
    }
}