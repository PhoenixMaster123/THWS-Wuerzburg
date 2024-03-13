public class Person
{
    public String vorname;
    public String nachname;
    public String adresse;

    public Person(String vorname, String nachname, String adresse)
    {
        if(!Character.isUpperCase(vorname.charAt(0)))
        {
            throw new RuntimeException();
        }
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }
}
