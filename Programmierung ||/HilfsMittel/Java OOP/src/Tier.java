public class Tier extends Lebewesen
{
    String geräusch;
    boolean kannFliegen;

    public Tier(int alter, double grosse, String geräusch, boolean kannFliegen)
    {
        super(alter,grosse);
        this.geräusch = geräusch;
        this.kannFliegen = kannFliegen;
    }
    public void macheGeräusch()
    {
        System.out.println(geräusch);
    }
}
