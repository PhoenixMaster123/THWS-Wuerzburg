public class Adresse
{
    public String strasse;
    public String hausnummer;
    public String postleitzahl;
    public String ort;

    public Adresse(String strasse, String hausnummer,String postleitzahl, String ort)
    {
        if (!Character.isUpperCase(strasse.charAt(0)) || !Character.isUpperCase(ort.charAt(0)) || !Character.isDigit(hausnummer.charAt(0)))
        {
            throw new RuntimeException();
        }
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
    }
}
