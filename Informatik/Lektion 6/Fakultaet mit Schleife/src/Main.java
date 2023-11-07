import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int fakultaet = Fakultaet(n);
        System.out.println(fakultaet);
    }

    private static int Fakultaet(int n) {
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }
}