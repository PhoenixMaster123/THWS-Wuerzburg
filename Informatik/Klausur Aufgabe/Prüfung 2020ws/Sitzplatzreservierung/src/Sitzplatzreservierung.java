public class Sitzplatzreservierung {

    // Eine Methode, die ein zweidimensionales charArray als Zuschauerfläche erzeugt
    public static char[][] erstelleSaal(int anzahlReihen) {
        // Die Anzahl der Sitze in der vordersten Reihe
        int anzahlSitze = 3;
        // Ein charArray, das die Zuschauerfläche repräsentiert
        char[][] saal = new char[anzahlReihen][];
        // Eine Schleife, die jede Reihe des Arrays initialisiert
        for (int i = 0; i < anzahlReihen; i++) {
            // Ein charArray, das die Sitze in einer Reihe repräsentiert
            char[] reihe = new char[anzahlSitze];
            // Eine Schleife, die jeden Sitz in einer Reihe mit dem Zeichen 'O' belegt
            for (int j = 0; j < anzahlSitze; j++) {
                reihe[j] = 'o';
            }
            // Die Reihe dem Saal hinzufügen
            saal[i] = reihe;
            // Die Anzahl der Sitze für die nächste Reihe um eins erhöhen
            anzahlSitze++;
        }
        // Das charArray zurückgeben
        return saal;
    }

    // Eine Methode, die den Saal zufällig mit dem Zeichen 'x' für belegt und 'o' für frei füllt
    public static void fuelleSitze(char[][] saal) {
        // Eine Schleife, die jede Reihe des Saals durchläuft
        for (int i = 0; i < saal.length; i++) {
            // Eine Schleife, die jeden Sitz in einer Reihe durchläuft
            for (int j = 0; j < saal[i].length; j++) {
                // Eine Zufallszahl zwischen 0 und 1 erzeugen
                double zufall = Math.random();
                // Wenn die Zufallszahl kleiner als 0.5 ist, den Sitz mit 'x' belegen
                if (zufall < 0.5) {
                    saal[i][j] = 'x';
                }
            }
        }
    }

    // Eine Methode, die es ermöglicht, in einer bestimmten Reihe einen bestimmten Sitz zu buchen
    public static void bucheSitz(char[][] saal, int reihe, int sitz) {
        // Prüfen, ob die Reihe und der Sitz gültig sind
        if (reihe >= 0 && reihe < saal.length && sitz >= 0 && sitz < saal[reihe].length) {
            // Prüfen, ob der Sitz frei ist
            if (saal[reihe][sitz] == 'o') {
                // Den Sitz mit 'x' belegen
                saal[reihe][sitz] = 'x';
                // Eine Erfolgsmeldung ausgeben
                System.out.println("Sitz " + sitz + " in Reihe " + reihe + " wurde gebucht.");
            } else {
                // Eine Fehlermeldung ausgeben
                System.out.println("Platz nicht frei.");
            }
        } else {
            // Eine Fehlermeldung ausgeben
            System.out.println("Ungültige Reihe oder Sitz.");
        }
    }

    // Eine Methode, die den Saal auf der Konsole darstellt
    public static void zeigeSaal(char[][] saal) {
        // Eine Schleife, die jede Reihe des Saals von hinten nach vorne durchläuft
        for (int i = saal.length - 1; i >= 0; i--) {
            // Eine Schleife, die jeden Sitz in einer Reihe durchläuft
            for (int j = 0; j < saal[i].length; j++) {
                // Den Sitz auf der Konsole ausgeben
                System.out.print(saal[i][j]);
            }
            // Einen Zeilenumbruch ausgeben
            System.out.println();
        }
    }


}

