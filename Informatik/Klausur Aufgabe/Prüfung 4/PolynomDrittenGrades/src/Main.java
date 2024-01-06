public class Main {
    public static void main(String[] args)
    {
        Polynom3 polynom3 = new Polynom3(1.5,4,1.3,-8);

        System.out.println(polynom3.berechneAnDerStelleX(2));
        polynom3.leiteAb();
        System.out.println(polynom3.toString());

        double[] koeffizienten = {1.5, 4.0, 1.3, -8.0 , 1};
        PolynomN polynom = new PolynomN(koeffizienten);

        System.out.println();

        System.out.println("Polynom: " + polynom);
        System.out.println(polynom.berechneAnDerStelleX(2));
        System.out.println("1. Ableitung: " + polynom.leiteAb());
    }
}