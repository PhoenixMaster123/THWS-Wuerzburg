// Die Klasse Kurs repräsentiert einen Kurs der Dragon Academy
class Kurs {
    // Attribute
    private String kursart; // die Art der Kampfkunst, z.B. Karate, Judo, etc.
    private int kursdauer; // die Dauer des Kurses in Minuten, z.B. 30, 60, 90
    private Mitglied[] mitglieder; // das Array der Mitglieder, die den Kurs belegen
    private int anzahl; // die aktuelle Anzahl der Mitglieder im Kurs
    private int maxAnzahl; // die maximale Anzahl der Mitglieder im Kurs

    // Konstruktor
    public Kurs(String kursart, int kursdauer, int maxAnzahl) {
        this.kursart = kursart;
        this.kursdauer = kursdauer;
        this.maxAnzahl = maxAnzahl;
        this.mitglieder = new Mitglied[maxAnzahl]; // das Array hat die Größe der maximalen Anzahl
        this.anzahl = 0; // die Anzahl ist zunächst 0
    }

    // Getter- und Setter-Methoden
    public String getKursart() {
        return kursart;
    }

    public int getKursdauer() {
        return kursdauer;
    }

    public Mitglied[] getMitglieder() {
        return mitglieder;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    // Die Methode anmeldungKurs fügt ein Mitglied zum Kurs hinzu, wenn möglich
    public void anmeldungKurs(Mitglied mitglied) {
        // Überprüfen, ob das Mitglied bereits einen Kurs belegt hat
        if (mitglied.getKurs() != null) {
            System.out.println("Das Mitglied mit der Nummer " + mitglied.getMitgliedsnummer() + " ist bereits für einen anderen Kurs angemeldet.");
            return; // die Methode beenden
        }
        // Überprüfen, ob das Mitglied bereits im Kurs ist
        for (int i = 0; i < anzahl; i++) {
            if (mitglieder[i].getMitgliedsnummer() == mitglied.getMitgliedsnummer()) {
                System.out.println("Das Mitglied mit der Nummer " + mitglied.getMitgliedsnummer() + " ist bereits für diesen Kurs angemeldet.");
                return; // die Methode beenden
            }
        }
        // Überprüfen, ob der Kurs voll ist
        if (anzahl == maxAnzahl) {
            System.out.println("Der Kurs ist leider voll. Es können keine weiteren Mitglieder aufgenommen werden.");
            return; // die Methode beenden
        }
        // Das Mitglied zum Kurs hinzufügen
        mitglieder[anzahl] = mitglied; // das Mitglied an die nächste freie Position im Array setzen
        anzahl++; // die Anzahl der Mitglieder im Kurs erhöhen
        mitglied.setKurs(this); // das Kurs-Attribut des Mitglieds auf diesen Kurs setzen
        System.out.println("Das Mitglied mit der Nummer " + mitglied.getMitgliedsnummer() + " wurde erfolgreich für den Kurs angemeldet.");
    }

    // Die Methode abmeldungKurs entfernt ein Mitglied vom Kurs, wenn vorhanden
    public void abmeldungKurs(Mitglied mitglied) {
        // Überprüfen, ob das Mitglied im Kurs ist
        int index = -1; // der Index des Mitglieds im Array, oder -1, wenn nicht gefunden
        for (int i = 0; i < anzahl; i++) {
            if (mitglieder[i].getMitgliedsnummer() == mitglied.getMitgliedsnummer()) {
                index = i; // den Index merken
                break; // die Schleife beenden
            }
        }
        if (index == -1) {
            System.out.println("Das Mitglied mit der Nummer " + mitglied.getMitgliedsnummer() + " ist nicht für diesen Kurs angemeldet.");
            return; // die Methode beenden
        }
        // Das Mitglied vom Kurs entfernen
        mitglieder[index] = mitglieder[anzahl - 1]; // das letzte Mitglied im Array an die Position des zu entfernenden Mitglieds setzen
        mitglieder[anzahl - 1] = null; // das letzte Mitglied im Array auf null setzen
        anzahl--; // die Anzahl der Mitglieder im Kurs verringern
        mitglied.setKurs(null); // das Kurs-Attribut des Mitglieds auf null setzen
        System.out.println("Das Mitglied mit der Nummer " + mitglied.getMitgliedsnummer() + " wurde erfolgreich vom Kurs abgemeldet.");
    }
}