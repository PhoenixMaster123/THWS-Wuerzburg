import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // a)
        Scanner sc = new Scanner(System.in);
        int zahl = Integer.parseInt(sc.nextLine());

        if (zahl % 7 == 0) {
            System.out.println(zahl);
        }
    }
}

        //b) 1 Aufgabe - negative Zahl

       /* Wenn der Modulo-Operator auf negative Operanden angewendet wird,
       gibt er das nicht-negative Restergebnis zurück.
       Das bedeutet, dass a % b dasselbe Ergebnis wie a % -b liefern wird.
        */

       //Aufgabe - Kommazahlen
       /*
       Modulo-Operator in Java kann nur auf ganzzahlige Werte angewendet werden.
        */