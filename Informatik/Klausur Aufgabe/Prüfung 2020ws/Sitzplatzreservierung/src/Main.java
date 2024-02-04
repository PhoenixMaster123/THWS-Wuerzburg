public class Main {
    public static void main(String[] args) {

        // Einen Saal mit 5 Reihen erzeugen
        char[][] saal = Sitzplatzreservierung.erstelleSaal(5);
        // Die Belegung der Sitzplätze zufällig erzeugen
        Sitzplatzreservierung.fuelleSitze(saal);
        // Den Saal vor der Buchung darstellen
        System.out.println("Saal vor der Buchung:");
        Sitzplatzreservierung.zeigeSaal(saal);
        // Einen Sitzplatz in der 3. Reihe und dem 2. Sitz buchen
        Sitzplatzreservierung.bucheSitz(saal, 2, 1);
        // Den Saal nach der Buchung darstellen
        System.out.println("Saal nach der Buchung:");
        Sitzplatzreservierung.zeigeSaal(saal);
    }
}