import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        double y = 1;
        double result;
        int yi = 1;
        do {

            result = (x/y + y) / 2;
            if(yi == x)
            {
                break;
            }
            y = result;
            yi++;

        }
        while (true);

        System.out.println(result);


        double sqrt = Math.sqrt(x);
        if(result == sqrt)
        {
            System.out.println("Die Ergebnis ist gleich");
        }
        else
        {
            System.out.println("Die Ergebnis ist nicht gleich");
        }

    }
}