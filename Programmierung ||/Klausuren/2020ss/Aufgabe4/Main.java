package Klausurvorberaitung.ss2020.Aufgabe4;

public class Main {
    public static void main(String[] args) {
        // Builder verwenden
        Spieldaten daten = new Spieldaten.SpieldatenBuilder()
                .geld(1000)
                .add("abc")
                .add("xyz")
                .build();

        // Ausgabe
        System.out.println("Geld: " + daten.getGeld()); // 1000
        System.out.println("Spieler: " + daten.getSpielerIDs()); // [abc, xyz]

        // Versuch, die Liste zu verändern
        try {
            daten.getSpielerIDs().add("bla");
        } catch (UnsupportedOperationException e) {
            System.out.println("Liste ist unveränderlich!"); // Dieser Block wird aufgerufen
        }
    }
}
