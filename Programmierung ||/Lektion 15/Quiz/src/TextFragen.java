public class TextFragen extends Fragen{
    public TextFragen(String frage)
    {
        super(frage);
    }
    @Override
    public void BuildBogen()
    {
        System.out.println(super.frage + "\n" + "Antwort:" + "\n\n");
    }
}
