public class Zielort
{
    private String nameZielort;
    private double distanz;
    private Zielort next;

    public Zielort (String nameZielort, double distanz)
    {
        this.nameZielort = nameZielort;
        this.distanz = distanz;
        this.next = null;
    }

    public String getNameZielort()
    {
        return nameZielort;
    }

    public void setNameZielort(String nameZielort)
    {
        this.nameZielort = nameZielort;
    }

    public double getDistanz()
    {
        return distanz;
    }

    public void setDistanz(double distanz)
    {
        this.distanz = distanz;
    }

    public Zielort getNext()
    {
        return next;
    }
    public void setNext(Zielort next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "Ortsname: " + nameZielort + " Distanz: " + distanz + " km";
    }
}
