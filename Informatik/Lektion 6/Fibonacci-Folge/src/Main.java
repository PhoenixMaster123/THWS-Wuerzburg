import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        n = fibonacci(n);
        System.out.println(n);
    }

    private static int fibonacci(int n) {

        if(n== 1 || n == 2)
        {
            return 1;
        }
        else
        {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}