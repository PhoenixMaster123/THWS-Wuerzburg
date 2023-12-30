public class Zielort
{
    String nameZielort;
    int distanz;
    Zielort next;

    public Zielort (String nameZielort, int distanz)
    {
        this.nameZielort = nameZielort;
        this.distanz = distanz;
    }

    public String getNameZielort()
    {
        return nameZielort;
    }

    public void setNameZielort(String nameZielort)
    {
        this.nameZielort = nameZielort;
    }

    public int getDistanz()
    {
        return distanz;
    }

    public void setDistanz(int distanz)
    {
        this.distanz = distanz;
    }

    public String toString()
    {
        return "Ortsname: " + nameZielort + "Distanz: " + distanz + " km";
    }
}
