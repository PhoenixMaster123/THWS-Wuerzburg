import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        if(num.length() > 7)
        {
            System.out.println("Lenght kann nicht mehr als 7 Zeichen sein");
        }
        else
        {
            int number = Integer.parseInt(num);
            int korrektNumber = number / 100000;
            if(korrektNumber == 50 || korrektNumber == 51 || korrektNumber == 61)
            {
                System.out.printf("Die Matrikelnummer %d ist korrekt",number);
            }
            else
            {
                System.out.printf("Matrikelnummer %d ist falsch",number);
            }
        }



    }
}