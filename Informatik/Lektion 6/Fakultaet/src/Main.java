import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long zahl = scanner.nextLong();
        int count = 0;
        long result = 1;
         boolean k = false;
/////////////////////////////////// Umgekehrt //////////////////////////////////
        for (int i = 1; i <= zahl ; i++) {

            if(zahl % i == 0)
            {
                result = zahl / i;
                zahl = result;
                count++;
                k = true;
            }
            else
            {
                k = false;
                System.out.println("Nicht gültige Zahl");
                break;
            }

        }
        if(k)
        {
            System.out.println(count + "!");
        }



        /* for (int i = 1; i <= zahl; i++) {

            result *= i;
            if(result % i == 0)
            {
               k = true;
            }
            else
            {
                k = false;
                System.out.println("Nicht gültige Zahl");
                break;
            }
        }
        if(k)
        {
            System.out.println(zahl + "! = " + result);
        }

         */

    }
}