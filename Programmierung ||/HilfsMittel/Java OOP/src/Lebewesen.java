public class Lebewesen
{
    int alter;
    double grosse;

    public Lebewesen(int alter, double grosse)
    {
        this.alter = alter;
        this.grosse = grosse;
        System.out.println("Lebewesen Konstruktor");
    }
    public void fortPflanzen()
    {
        System.out.println("Fortpflanzen....");
    }
    public void wachsen()
    {
        this.grosse++;
    }
}
