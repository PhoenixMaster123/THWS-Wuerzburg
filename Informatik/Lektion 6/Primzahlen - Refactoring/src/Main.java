import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int prim = scanner.nextInt();
        boolean primzahl = PrimZahl(prim);
        System.out.println(primzahl);
    }

    private static boolean PrimZahl(int prim) {
        if (prim <= 1) {
            return false;
        }
        for (int i = 2; i < prim; i++) {

            if (prim % i == 0) {
                return false;
            }
        }
        return true;

    }
}