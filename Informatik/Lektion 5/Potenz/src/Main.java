import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double b = scanner.nextDouble();
        int n = scanner.nextInt();
        int count = 0;
        double result = 1;
        do {
            if(n > 0)
            {
                result *= b;
                count++;
            } else if (n == 0) {
                break;
            } else if (n < 0) {
                result *= 1 / b;
                count--;
            }
        }
        while (count != n);

        System.out.println(result);
    }
}