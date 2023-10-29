import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double result = 1;
        int k = 1;
        do {
            result *= 6 * (1/ Math.pow(k,2));
            k++;
        }
        while (result > Math.pow(10, -5));


        System.out.println(result);

    }
}