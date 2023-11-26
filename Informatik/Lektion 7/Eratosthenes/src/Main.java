import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int obergrenze = scanner.nextInt();
        int[] zahlen = fillArray(obergrenze);

        System.out.print("Zahlen: ");
        for (int i:zahlen)
        {
            System.out.print(i + " ");
        }



    }
    private static int[] fillArray(int obergrenze) {
        int[] zahlen = new int[obergrenze+1];
        boolean k;
        for (int i = 0; i <= obergrenze; i++) {
            if (primZahlen(i)) {
                zahlen[i] = i;
                k = true;
                showContent(k, i);
            } else {
                zahlen[i] = -1;
                k = false;
                showContent(k, i);
            }

        }
        return zahlen;
    }
        private static void showContent(boolean k, int zahl)
        {
            if(k)
            {
                System.out.println(zahl + " is a prime number. ");
            }
            else
            {
                System.out.println(zahl + " is not a prime number. ");
            }
        }
    private static boolean primZahlen(int obergrenze) {
        if (obergrenze <= 1) {
            return false;
        }
        for (int i = 2; i * i <= obergrenze; i++) {

            if (obergrenze % i == 0) {
                return false;
            }
            return true;
        }
        return true;
    }
}

        //////////////////////////////////////////////////////// Clear Variant /////////////////////////////////////
        /*
        Scanner scanner = new Scanner(System.in);
        int obergrenze = scanner.nextInt();
        int position = 0;
        int allPrimzahlCounter = 0;
        int allNotPrimZahlCounter = 0;
        for (int i = 0; i <= obergrenze; i++) {
            if(primZahlen(i))
            {
                allPrimzahlCounter++;
            }
            else
            {
                allNotPrimZahlCounter++;
            }
        }
        int[] notPrimzahlen = sieve(obergrenze,position,allNotPrimZahlCounter);
        int[] primZahlen = fillArray(obergrenze,position,allPrimzahlCounter);

        System.out.print("Primzahlen: ");
        for (int i : primZahlen) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Not Primzahlen: ");
        for (int i : notPrimzahlen)  // foreach
        {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    private static int[] fillArray(int obergrenze, int position, int counter)
    {
        int[] primZahlen = new int[counter];
        boolean k;
        for (int i = 0; i <= obergrenze; i++)
        {
            if(primZahlen(i))
            {
                primZahlen[position] = i;
                k = true;
                showContent(k,i);
                position++;
            }
            else
            {

                k = false;
                showContent(k,i);
            }

        }
        return primZahlen;

    }
    private static void showContent(boolean k, int zahl)
    {
       if(k)
       {
           System.out.println(zahl + " is a prime number. ");
       }
       else
       {
           System.out.println(zahl + " is not a prime number. ");
       }
    }
    private static int[] sieve(int obergrenze, int position, int allNotPrimzahlCounter)
    {
        boolean k = false;
        int[] notPrimZahlen = new int[allNotPrimzahlCounter];
        for (int i = 0; i <= obergrenze; i++) {

            if(!primZahlen(i))
            {
                notPrimZahlen[position] = i;
                position++;
            }
        }
        return notPrimZahlen;
    }
    private static boolean primZahlen(int obergrenze)
    {
        if(obergrenze <= 1)
        {
            return false;
        }
        for (int i = 2; i * i <= obergrenze; i++) {

            if (obergrenze % i == 0) {
                return false;
            }
            return true;
        }

        return true;
    }
   }
           */
