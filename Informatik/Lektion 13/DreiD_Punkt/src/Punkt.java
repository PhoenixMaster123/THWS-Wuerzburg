public class Punkt {
    int a;
    int b;
    int c;

    public Punkt(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double berechneAbstand(int a, int b, int c)
    {
        return Math.sqrt(a * a + b * b + c * c);
    }
    public String toString()
    {
        return "Beispiel für Punkt P(" + a + "," + b + "," + c + ")" +
        "\na=" + a + ", b=" + b + ", c=" + c;
    }
}
