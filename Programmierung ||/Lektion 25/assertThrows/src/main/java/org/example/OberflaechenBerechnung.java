package org.example;

public class OberflaechenBerechnung
{
    public static String berechneOberflaeche(int a, int b, int c)
    {
        if (a < 0 || b < 0 || c < 0)
        {
            throw new RuntimeException("Ungültiges Argument");
        }
        else
        {
            return "Die Oberfläche des Quaders beträgt: " + (2*a*b+2*a*c+2*b*c);
        }
    }
}
