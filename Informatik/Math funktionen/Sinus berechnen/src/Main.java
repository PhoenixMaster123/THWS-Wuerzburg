public class Main {
    public static void main(String[] args) {

        try {
            double zahl = 1;
            double result = berechneSin(zahl);
            System.out.println(result);
        }
        catch (RuntimeException e)
        {
            System.out.println("Fehler " + e.getMessage());
        }
    }

    private static double berechneSin(double x)
    {
        double sum = 0;
        double delta = 0;
        int k = 0;
        do {
            delta = power(-1 , k) * power(x, 2*k + 1) / fakt(2 * k + 1);
            sum += delta;
            k++;
        }while (k < 5);
        return sum;
    }
    public static double power (double base, double exp)
    {
        double result = 1;
        for (int i = 0; i < exp; i++)
        {
            result *= base;
        }
        return result;
    }
    public static double fakt(double n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * fakt(n-1);
        }
    }
}