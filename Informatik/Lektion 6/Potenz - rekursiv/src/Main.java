import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int basis = scanner.nextInt();
        int exponent = scanner.nextInt();
        int count = 1;
        double sum = 1;

        double result = Potenz(basis, exponent, count, sum);
        System.out.println( (int) result);
    }

    private static double Potenz(int basis, int exponent, int count, double sum) {


        if(exponent == count - 1 ) {
            return sum;
        }

        sum *= basis;
        count++;
        return Potenz(basis, exponent,count, sum);
    }
}