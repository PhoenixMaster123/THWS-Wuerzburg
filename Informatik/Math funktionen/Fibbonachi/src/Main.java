public class Main {
    public static void main(String[] args) {

        double zahl = 10;
        double fib = berechneFib(zahl);
        System.out.println(fib);
    }

    private static double berechneFib(double zahl)
    {
        if (zahl == 0 || zahl == 1)
        {
            return zahl;
        }
        return berechneFib(zahl - 1) + berechneFib(zahl - 2);
    }
}