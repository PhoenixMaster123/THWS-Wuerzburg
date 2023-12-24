public class Elementen
{
    String name;
    String kuerzel;
    int ordnungszahl;
    String gruppe;

    public Elementen(String name, String kuerzel, int ordnungszahl, String gruppe)
    {
        this.name = name;
        this.kuerzel = kuerzel;
        this.ordnungszahl = ordnungszahl;
        this.gruppe = gruppe;
    }
    public String toString() {
        return name + " (" + kuerzel + ")";
    }
}

