import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Drei Kurse erstellen
        Kurs karate = new Kurs("Karate", 60, 10); // ein Karate-Kurs mit 60 Minuten Dauer und 10 maximalen Teilnehmern
        Kurs judo = new Kurs("Judo", 90, 8); // ein Judo-Kurs mit 90 Minuten Dauer und 8 maximalen Teilnehmern
        Kurs wingchun = new Kurs("WingChun", 30, 12); // ein WingChun-Kurs mit 30 Minuten Dauer und 12 maximalen Teilnehmern

        // Ein Scanner-Objekt erstellen
        Scanner scanner = new Scanner(System.in);

        // Eine Kursart einlesen
        System.out.println("Bitte geben Sie eine Kursart ein: Karate, Judo oder WingChun.");
        String kursart = scanner.nextLine();

        // Eine Schleife, die solange läuft, bis eine gültige Kursart eingegeben wird
        while (!kursart.equals("Karate") && !kursart.equals("Judo") && !kursart.equals("WingChun")) {
            // Eine RuntimeException werfen und fangen
            try {
                throw new RuntimeException("Dieser Kurs wird leider nicht angeboten!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // die Standardausgabe der Exception anzeigen
            }
            // Eine neue Kursart einlesen
            System.out.println("Bitte geben Sie eine gültige Kursart ein: Karate, Judo oder WingChun.");
            kursart = scanner.nextLine();
        }

        // Den ausgewählten Kurs bestimmen
        Kurs kurs = null; // der ausgewählte Kurs, oder null, wenn keiner gefunden wird
        if (kursart.equals("Karate")) {
            kurs = karate; // den Karate-Kurs auswählen
        } else if (kursart.equals("Judo")) {
            kurs = judo; // den Judo-Kurs auswählen
        } else if (kursart.equals("WingChun")) {
            kurs = wingchun; // den WingChun-Kurs auswählen
        }

        // Die Kursdauer und die maximale Teilnehmerzahl anzeigen
        System.out.println("Sie haben den Kurs " + kursart + " ausgewählt. Die Kursdauer beträgt " + kurs.getKursdauer() + " Minuten und die maximale Teilnehmerzahl ist " + kurs.getMaxAnzahl() + ".");
    }
}