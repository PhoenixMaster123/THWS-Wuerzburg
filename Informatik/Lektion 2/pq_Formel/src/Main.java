import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double p = sc.nextDouble();
        double q = sc.nextDouble();
        double x1;
        double x2;
        double sqrt = 0.5 * ((p / 2) * (p / 2) - q); // Math.sqrt((p / 2) * (p / 2) - q)
        if ((p/2)*(p/2) - q < 0)
        {
            System.out.println("Unter der Wurzel kann kein negativer Wert steht.");
        }
        x1 = -p/2 + sqrt;
        x2 = -p/2 - sqrt;

        System.out.println(x1);
        System.out.println(x2);

    }
}
