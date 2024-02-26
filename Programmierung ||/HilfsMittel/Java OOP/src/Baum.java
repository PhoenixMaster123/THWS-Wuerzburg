public class Baum extends Pflanze
{
    int wurzeln;

    public Baum(int alter, double grosse, boolean hatNadeln, int wurzeln)
    {
        super(alter, grosse, hatNadeln);
        this.wurzeln = wurzeln;
    }
}
