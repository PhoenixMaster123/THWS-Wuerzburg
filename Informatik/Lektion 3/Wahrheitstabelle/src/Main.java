import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char einzelzeichen1 = sc.nextLine().charAt(0);
        char einzelzeichen2 = sc.nextLine().charAt(0);

        if(einzelzeichen1 == 'f' && einzelzeichen2 == 'f')
        {
            System.out.println("Ausgabewert: 0");
        }
        else if(einzelzeichen1 == 'f' && einzelzeichen2 == 't')
        {
            System.out.println("Ausgabewert: 1");
        }
        else if(einzelzeichen1 == 't' && einzelzeichen2 == 'f')
        {
            System.out.println("Ausgabewert: 2");
        }
        else if(einzelzeichen1 == 't' && einzelzeichen2 == 't')
        {
            System.out.println("Ausgabewert: 3");
        }
        else
        {
            throw new RuntimeException("Keine gültige Kombination");
        }
    }
}
