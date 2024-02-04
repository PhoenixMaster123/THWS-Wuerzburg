public class Roboter
{
    private String name;
    private int gross;
    private Roboter next;

    public Roboter(String name, int gross)
    {
        this.name = name;
        this.gross = gross;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getGross()
    {
        return gross;
    }
    public void setGross(int gross)
    {
        this.gross = gross;
    }
    public Roboter getNext()
    {
        return next;
    }
    public void setNext(Roboter next)
    {
        this.next = next;
    }
    public String toString()
    {
        return "Hallo ich bin " + name + " , ich bin " + gross + " Zentimeter groß.";
    }
}
