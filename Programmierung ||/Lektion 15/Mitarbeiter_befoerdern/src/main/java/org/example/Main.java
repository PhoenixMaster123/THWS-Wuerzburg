package org.example;

public class Main {
    public static void main(String[] args) {

        // Beispiel Verwendung
        // Angestellte erstellen
        Angestellter employee1 = new Angestellter("Mustermann", "Max", 1, 50000, 1, "1990-5-15");
        Angestellter employee2 = new Angestellter("Musterfrau", "Erika", 2, 60000, 1, "1985-10-3");

        // Abteilungsleiter erstellen
        Abteilungsleiter leader = new Abteilungsleiter("Leiter", "Hans", 100, 80000,1, "1978-8-20");

        // Beispiel Gehaltsberechnung
        System.out.println("Gehalt von " + employee1.vorname + " " + employee1.nachname + ": " + employee1.calculateGehalt() + " Euro");
        System.out.println("Gehalt von " + employee2.vorname + " " + employee2.nachname + ": " + employee2.calculateGehalt() + " Euro");
        System.out.println("Gehalt von " + leader.vorname + " " + leader.nachname + ": " + leader.calculateGehalt() + " Euro");

        // Beispiel Beförderung
        leader.Angestellterbefoerdert(employee1);
        System.out.println("Neues Gehalt von " + employee1.vorname + " " + employee1.gehaltFaktor + " nach Beförderung: " + leader.Angestellterbefoerdert(employee1) + " Euro");
    }
}