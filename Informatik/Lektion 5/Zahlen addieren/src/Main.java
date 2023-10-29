import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int result = 0;
        do {
            num = scanner.nextInt();
            result +=num;

        }
        while (num != 0);

        System.out.println("Summe: " + result);
    }
}