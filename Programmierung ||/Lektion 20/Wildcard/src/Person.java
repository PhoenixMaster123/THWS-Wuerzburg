public class Person {
    String vorname;
    String nachname;
    public Person(String vorname, String nachname)
    {
        this.vorname = vorname;
        this.nachname = nachname;
    }
    public String toString()
    {
        return vorname + " " + nachname;
    }
}
