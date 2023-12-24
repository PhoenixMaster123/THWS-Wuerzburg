public class Main {
    public static void main(String[] args) {

        System.out.println(calculateValue(100.0));
        System.out.println(calculateValue(100,10));
        System.out.println(calculateValue((short) 100,21.0));
        System.out.println(calculateValue(1000L,21.0));
        System.out.println(calculateValue(100.09f,21.98476));
        System.out.println(calculateValue(100.2093,21.938));
    }
    public static final float VAT_GERMANY = 18.05f;

    public static double calculateValue(double amount, double vat)
    {
        return amount * (vat / 100.0);
    }
    public static int calculateValue(int amount, int vat)
    {
        return (int) calculateValue(amount,VAT_GERMANY);
    }
    public static double calculateValue(short amount)
    {
        return (short) calculateValue(amount, VAT_GERMANY);
    }
    public static long calculateValue(long amount)
    {
        return (long) calculateValue(amount,VAT_GERMANY);
    }
    public static float calculateValue(float amount)
    {
        return (float) calculateValue(amount, VAT_GERMANY);
    }
    public static double calculateValue(double amount)
    {
        return calculateValue(amount, VAT_GERMANY);
    }




}