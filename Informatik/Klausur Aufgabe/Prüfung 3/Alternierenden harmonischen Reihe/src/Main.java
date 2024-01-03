public class Main {
    public static void main(String[] args) {

        double sum = 0;
        int sign = 1;

        for (int k = 1; k <= 10000; k++) {
            double term = (double) sign / k;
            sum += term;
            sign *= -1;  // Ändert das Vorzeichen für den nächsten Term
        }

        System.out.println("Die Summe der ersten 10000 Glieder der alternierenden harmonischen Reihe ist: " + sum);
    }
}