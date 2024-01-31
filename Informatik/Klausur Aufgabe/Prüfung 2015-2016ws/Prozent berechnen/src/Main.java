import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int zahl1 = scanner.nextInt();
        int zahl2 = scanner.nextInt();
        System.out.println(berechneProzent(zahl1,zahl2));
    }
    public static double berechneProzent(int zahl1, int zahl2)
    {
        double firstZahl = (double) zahl1;
        double secondZahl = (double) zahl2;
        if (zahl1 >= 0 && zahl2 >= 0)
        {
            return (firstZahl * secondZahl) / 100;
        }
        return -1.0;
    }
}