import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {

            for (int j = 1; j <= 10; j++) {

                System.out.println(i + " x " + j + " = " + i * j);
            }
        }
    }
}