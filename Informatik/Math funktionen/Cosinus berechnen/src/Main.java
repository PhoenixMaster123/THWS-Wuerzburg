public class Main {
    public static void main(String[] args) {

        try
        {
            double zahl = 1;
            double result = berecneCos(zahl);
            System.out.println(result);
        }
        catch (RuntimeException e)
        {
            System.out.println("Fehler " + e.getMessage());
        }

    }
    public static double berecneCos(double x)
    {
        if (x < -1 || x > 1)
        {
            throw new RuntimeException("x muss zwischen -1 und 1 liegen");
        }
        double sum = 0;
        double delta = 0;
        int k = 0;
        do {
            delta = power(-1, k) * power(x, 2 * k) / fakt (2 * k);
            sum +=delta;
            k++;
        }
        while (k  < 5);
        return sum;
    }
    public static double power(double base, double exponent)
    {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    public static double fakt(double x)
    {
        if (x == 0 || x == 1)
        {
            return 1;
        }
        else
        {
            return x * fakt(x-1);
        }
    }
}