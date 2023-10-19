import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char einzelzeichnen = sc.nextLine().charAt(0);
        boolean t = false;
        if (Character.isUpperCase(einzelzeichnen)) {
            System.out.println("Großbuchstabe");
             t = true;
        }
        if ((einzelzeichnen >= '0' && einzelzeichnen <= '9') ||
                (einzelzeichnen >= 'a' && einzelzeichnen <= 'f') ||
                (einzelzeichnen >= 'A' && einzelzeichnen <= 'F')) {
            System.out.println("Hexadezimale Ziffer.");
            t = true;
        }
        if (einzelzeichnen >= '0' && einzelzeichnen <= '1')
        {
            System.out.println("Binäre Ziffer");
            t = true;
        }
        if (einzelzeichnen >= '0' && einzelzeichnen <= '7')
        {
            System.out.println("Oktale Ziffer");
            t = true;
        }
        if(t != true)
        {
            System.out.println("Unbekannt");
        }






    }
}