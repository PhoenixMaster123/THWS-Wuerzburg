package org.example;

public class QuadraticFunction
{
    double a;
    double b;
    double c;

    public QuadraticFunction(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double[] roots()
    {
        double result1;
        double result2;

        result1 = (-b + (Math.sqrt(Math.pow(b,2) - 4 * a * c))) / (2 * a);
        result2 = (-b - (Math.sqrt(Math.pow(b,2) - 4 * a * c))) / (2 * a);
        double[] result = new double[2];
        result[0] = result1;
        result[1] = result2;

        return result;
    }
}
