class Mitglied {
    // Attribute
    private int mitgliedsnummer; // die eindeutige Nummer des Mitglieds
    private Kurs kurs; // der Kurs, an dem das Mitglied teilnimmt, oder null, wenn kein Kurs belegt ist

    // Konstruktor
    public Mitglied(int mitgliedsnummer) {
        this.mitgliedsnummer = mitgliedsnummer;
        this.kurs = null;
    }

    // Getter- und Setter-Methoden
    public int getMitgliedsnummer() {
        return mitgliedsnummer;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
}