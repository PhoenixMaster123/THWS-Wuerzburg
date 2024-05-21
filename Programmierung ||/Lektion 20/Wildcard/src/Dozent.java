public class Dozent {
    String vorname;
    String nachname;
    String subject;
    public Dozent(String vorname, String nachname, String subject)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.subject = subject;
    }
    public String toString()
    {
        return vorname + " " + nachname + " " + subject;
    }
}
