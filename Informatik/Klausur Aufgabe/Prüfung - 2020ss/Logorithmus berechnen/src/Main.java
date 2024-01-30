public class Main {
    public static void main(String[] args) {
        try {
            double x = 1.5; // Setzen Sie hier den gewünschten Wert für x ein
            double lnResult = calculateNaturalLogarithm(x);
            System.out.println("ln(" + x + ") = " + lnResult);
        } catch (RuntimeException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public static double calculateNaturalLogarithm(double x) {
        // Überprüfen Sie, ob x zwischen 0 und 2 liegt
        if (x <= 0 || x >= 2) {
            // Werfen Sie eine Ausnahme, wenn die Bedingung nicht erfüllt ist
            throw new RuntimeException("x muss zwischen 0 und 2 liegen");
        }
        // Initialisieren Sie die Summe und den Wertzuwachs
        double sum = 0;
        double delta = 0;
        // Initialisieren Sie den Zähler n
        int n = 1;
        // Wiederholen Sie die Berechnung, bis der Wertzuwachs kleiner als |10-16| ist
        do {
            // Berechnen Sie den Wertzuwachs nach der Formel
            delta = power(-1, n + 1) * power(x - 1, n) / n;
            // Fügen Sie den Wertzuwachs zur Summe hinzu
            sum += delta;
            // Erhöhen Sie den Zähler n um 1
            n++;
        } while (abs(delta) > 1e-16);
        // Geben Sie die Summe als Ergebnis zurück
        return sum;
    }

    // Eine Hilfsmethode, um Potenzen zu berechnen
    public static double power(double base, int exponent) {
        // Initialisieren Sie das Ergebnis mit 1
        double result = 1;
        // Multiplizieren Sie das Ergebnis mit der Basis so oft wie der Exponent
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        // Geben Sie das Ergebnis zurück
        return result;
    }
    public static double abs(double x) {
        // Wenn x negativ ist, geben Sie -x zurück
        if (x < 0) {
            return -x;
        }
        // Sonst geben Sie x zurück
        else {
            return x;
        }
    }
}
