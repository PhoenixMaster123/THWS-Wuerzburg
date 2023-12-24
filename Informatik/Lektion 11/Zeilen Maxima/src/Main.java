public class Main {
    public static void main(String[] args) {

        double[][] matrix =
        {
                {4.5, 6.7, 8.9},
                {2.3, 5, 7.6},
                {1.2, 9.8, 5.4, 11.2}

        };
        double[] maxima = zeilenMaxima(matrix);
        System.out.println("Maxima jeder Zeile:");
            for (int i = 0; i < maxima.length; i++) {

                System.out.println("Zeile " + (i + 1) + ": " + maxima[i]);
            }

    }

    private static double[] zeilenMaxima(double[][] matrix)
    {
        int anzahlZeilen = matrix.length;
        double[] maxima = new double[anzahlZeilen];

        // Äußere Schleife

        for (int i = 0; i < anzahlZeilen; i++)
        {
            // Jede Zeile enthält mindestens ein Element
            double maxInZeile = matrix[i][0];

            // Innere Schleife

            for (int j = 0; j < matrix[i].length; j++)
            {
                // Maximum in der Zeile finden
                
                if (matrix[i][j] > maxInZeile)
                {
                    maxInZeile = matrix[i][j];
                }
            }
            maxima[i] = maxInZeile;
        }
        return maxima;
    }
}