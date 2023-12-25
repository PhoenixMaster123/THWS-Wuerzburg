public class Knoten
{
    String word;
    String bedeutung;

    Knoten left;
    Knoten right;

    public Knoten(String word, String bedeutung)
    {
        this.word = word;
        this.bedeutung = bedeutung;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public String getBedeutung()
    {
        return bedeutung;
    }

    public void setBedeutung(String bedeutung)
    {
        this.bedeutung = bedeutung;
    }
}
