import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int fahrenheit = sc.nextInt();
        fahrenheit -= 32;

        float celsius = 5/9f * fahrenheit;

        System.out.printf("%.2f", celsius);
       
    }
}