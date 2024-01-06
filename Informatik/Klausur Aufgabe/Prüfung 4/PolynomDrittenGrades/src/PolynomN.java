public class PolynomN
{
    double[] koeffizienten;

    public PolynomN(double[] koeffizienten)
    {
        this.koeffizienten = koeffizienten;
    }
    public double berechneAnDerStelleX(double x)
    {
        double ergebnis = 0;
        int grad = koeffizienten.length - 1;

        for (int i = 0; i < koeffizienten.length; i++)
        {
            double term = 1;
            for (int j = 0; j < grad; j++)
            {
                term *= x;
            }
            ergebnis += koeffizienten[i] * term;
            grad--;
        }
        return ergebnis;
    }

    public PolynomN leiteAb()
    {
        int neuerGrad = koeffizienten.length - 1;

        if (neuerGrad <= 0)
        {
            // Konstantes Polynom, Ableitung ist 0
            return new PolynomN(new double[]{0});
        }

        double[] ableitungKoeffizienten = new double[neuerGrad];
        for (int i = 0; i < neuerGrad; i++)
        {
            ableitungKoeffizienten[i] = (neuerGrad - i) * koeffizienten[i];
        }

        return new PolynomN(ableitungKoeffizienten);
    }



    @Override
    public String toString()
    {
        String result = "";

        for (int i = 0; i < koeffizienten.length; i++)
        {
            if (koeffizienten[i] != 0)
            {
                if (!result.isEmpty())
                {
                    result += " + ";
                }

                result += koeffizienten[i];

                if (i < koeffizienten.length - 1)
                {
                    result += "x^" + (koeffizienten.length - 1 - i);
                }
            }
        }

        return result;
    }

}
