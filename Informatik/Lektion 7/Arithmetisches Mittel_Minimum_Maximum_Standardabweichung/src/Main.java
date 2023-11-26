import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int schoolmates = scanner.nextInt();
        if (schoolmates <= 0)
        {
            System.out.println("Invalid input for schoolmates. Exiting the program.");
            System.exit(0); // Terminate
        }
        // int decimalPlaces = 2;
        // DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double[] notes = fillArray(schoolmates);
        double max = maxWert(notes);
        double min = minWert(notes);
        double aritmetischeMittel = aritmetischeMittel(schoolmates, notes);
       // double roundedMittel = roundToDecimalPlaces(aritmetischeMittel, decimalPlaces);

        int k = 1;
        //System.out.println(roundedMittel);
        for (int i = 0; i < notes.length; i++)
        {

            System.out.println(k + ". Wert: " + notes[i]);
            k++;
        }
        System.out.println("Kleinster Wert: " + min);
        System.out.println("Groesster Wert: " + max);
        System.out.println("Arithmetischer Mittelwert: " + aritmetischeMittel);
        // String roundedNumber = decimalFormat.format(aritmetischeMittel);

    }

    private static double minWert(double[] notes)
    {
        double[] min = notes;
        double term = min[0];
        for (int i = 1; i < min.length; i++)
        {
            if(min[i] < term)
            {
                term = min[i];
            }

        }
        double minWert = term;
        return minWert;
    }

    private static double maxWert(double[] notes)
    {
        double[] max = notes;
        double term = 0;
        for (int i = 0; i < max.length; i++)
        {
            if(term < max[i])
            {
                term = max[i];
            }

        }
       double maxWert = term;
        return maxWert;
    }

    private static double aritmetischeMittel(int schoolmates, double[] notes)
    {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        double[] grade = notes;
        for (int i = 0; i < grade.length; i++)
        {
            sum += grade[i];
        }
        /*for (int i = 1; i <= 5; i++) {
            double students = scanner.nextDouble();
           // notes[i-1] = students * i;
            notes[i-1] = students;
            sum += notes[i-1];
        }
        */

        return  sum / grade.length;
    }
    private static double[] fillArray(int schoolmates)
    {
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[schoolmates];
        for (int i = 0; i < schoolmates; i++)
        {
            double grades = scanner.nextDouble();
            arr[i] = grades;
        }
        return arr;
    }

   /* private static double roundToDecimalPlaces(double value, int decimalPlaces) {
        double factor = 1;
        for (int i = 0; i < decimalPlaces; i++) {
            factor *= 10;
        }

        double scaledValue = value * factor;
        double truncatedValue = (double) ((int) (scaledValue + 0.5));
        return truncatedValue / factor;
    }

    */
}