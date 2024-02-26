public class Pflanze extends Lebewesen
{
    boolean hatNadeln;

    public Pflanze(int alter, double grosse, boolean hatNadeln)
    {
        super(alter,grosse);
        this.hatNadeln = hatNadeln;
        System.out.println("Pflanze Konstruktor");
    }
    public void gebeFruchte()
    {
        System.out.println("Früchte...");
    }
}
