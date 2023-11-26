public class Main {
    public static void main(String[] args) {


        double x = 1;
        System.out.println(Sin(x));
        System.out.println(Math.sin(x));

    }

    public static double Sin(double x) {
        int genauigkeit = 10; // Anzahl der Iterationen für Genauigkeit
        double sinusWert = 0;

        for (int k = 0; k <= genauigkeit; k++) {
            double term = potenz(-1, k) * potenz(x, 2 * k + 1) / fakultaet(2 * k + 1);
            sinusWert += term;
        }

        return sinusWert;
    }

    public static double potenz(double basis, int exponent) {
        double ergebnis = 1;

        for (int i = 0; i < exponent; i++) {
            ergebnis *= basis;
        }

        return ergebnis;
    }
    public static double fakultaet(int n) {
        double ergebnis = 1;

        for (int i = 1; i <= n; i++) {
            ergebnis *= i;
        }

        return ergebnis;
    }
}