public class Polynom3
{
    double a;
    double b;
    double c;
    double d;

    public Polynom3 (double a, double b, double c, double d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double berechneAnDerStelleX(int x)
    {
        return a * (x * x * x) + b * (x * x) + c * x + d;
    }

    public void leiteAb()
    {
        double newA = 3 * a;
        double newB = 2 * b;
        double newC = c;

        Polynom3 abgeleitetesPolynom = new Polynom3(newA, newB, newC, 0);

        // Überprüfen, ob der Koeffizient mit Potenz 0 (d) nicht 0 ist
        if (abgeleitetesPolynom.d != 0) {
            System.out.println("1. Ableitung: " + abgeleitetesPolynom);
        } else {
            // Wenn der Koeffizient mit Potenz 0 (d) 0 ist, nur die Ableitung ohne d ausgeben
            System.out.println("1. Ableitung: " + abgeleitetesPolynom.a + "x^2 + " + abgeleitetesPolynom.b + "x + " + abgeleitetesPolynom.c);
        }
    }
    public String toString()
    {
        return a + "x^3" + " + " + b + "x^2" + " + " + c + "x" + " + " + d;
    }

}
