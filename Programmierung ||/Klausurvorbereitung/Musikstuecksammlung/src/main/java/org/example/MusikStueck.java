package org.example;

public class MusikStueck
{
    String titel; // Name des Musikstueckes
    String interpret; // Gruppe/Saenger des Stueckes
    int laenge; // Dauer in Sekunden
    public MusikStueck(String titel, String interpret, int laenge)
    {
        this.titel = titel;
        this.interpret = interpret;
        this.laenge = laenge;
    }
    public String toString()
    {
        return titel + " " + interpret + " " + laenge;
    }
}//endclass MusikStueck
