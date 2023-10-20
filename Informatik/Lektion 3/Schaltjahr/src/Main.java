import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int jahresZahl = sc.nextInt(); //Integer.parseInt(sc.nextLine());

        if(jahresZahl % 4 == 0 )
        {
            if(jahresZahl % 100 == 0)
            {
                if(jahresZahl % 400 == 0)
                {
                    System.out.println(jahresZahl + " ist Schaltjahr");
                    // Variant 2
                    // System.out.printf("%d ist Schaltjahr", jahresZahl);
                }
                else
                {
                    System.out.println(jahresZahl + " ist kein Schaltjahr");
                    // Variant 2
                    //System.out.printf("%d ist kein Schaltjahr", jahresZahl);
                }
            }
            else if(jahresZahl % 400 == 0)
            {
                System.out.println(jahresZahl + " ist Schaltjahr");
                // Variant 2
                // System.out.printf("%d ist Schaltjahr", jahresZahl);

            }
            else
            {
                System.out.println(jahresZahl + " ist Schaltjahr");
                // Variant 2
                //System.out.printf("%d ist Schaltjahr", jahresZahl);
            }
        }
        else
        {
            System.out.println(jahresZahl + " ist kein Schaltjahr");
            // Variant 2
            // System.out.printf("%d ist kein Schaltjahr", jahresZahl);
        }
    }
}
