public class Personenknoten
{
    int alter;
    String nachname;

    Personenknoten prev;
    Personenknoten next;

    public Personenknoten(int alter, String nachname)
    {
        this.alter = alter;
        this.nachname = nachname;
    }

}
