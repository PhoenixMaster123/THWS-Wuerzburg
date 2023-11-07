import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Dreieck(n);
        System.out.println();
    }

    private static void Dreieck(int n) {
        int count = 1;
        int newCount = n;
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if(newCount >= k)
                {
                    System.out.print(" "); // Push
                }
            }
            for (int k = 1; k <= n; k++) {

                if(count == k)
                {
                    System.out.print("* "); // Print Sterne
                    break;
                }
                System.out.print("* ");
            }
            System.out.println();
            newCount--;
            count++;

        }

    }
}