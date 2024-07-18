package org.example;

public class Main {
    public static void main(String[] args) {
        MusikStueckSammlung sammlung = new MusikStueckSammlung();

        // Beispielhafte Musikstücke hinzufügen
        sammlung.musikStueckEinfügen(new MusikStueck("Song A", "Interpret A", 180));
        sammlung.musikStueckEinfügen(new MusikStueck("Song C", "Interpret C", 240));
        sammlung.musikStueckEinfügen(new MusikStueck("Song B", "Interpret B", 200));
        sammlung.musikStueckEinfügen(new MusikStueck("Song D", "Interpret D", 210));

        // Alle Musikstücke nach Titel sortiert ausgeben
        MusikStueck[] alleMusikStuecke = sammlung.getAlleMusikStueckeNachTitel();
        for (MusikStueck stueck : alleMusikStuecke) {
            System.out.println(stueck);
        }
    }
}