public class Kunde
{
    String name;
    int alter;
    String email;
    String telefonnummer;

    public Kunde()
    {
        System.out.println("Leerer Konstruktor");
    }
    public Kunde(String name,int alter)
    {
        this.name = name;
        this.alter = alter;
        email = "";
        telefonnummer = "";
        System.out.println("Konstruktor mit 2 Argumenten");
    }
    public Kunde(String name, int alter, String email, String telefonnummer)
    {
        this.name = name;
        this.alter = alter;
        this.email = email;
        this.telefonnummer = telefonnummer;
        System.out.println("Konstruktor mit allen Argumenten");
    }
}
