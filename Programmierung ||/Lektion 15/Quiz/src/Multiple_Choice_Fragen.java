public class Multiple_Choice_Fragen extends Fragen{
    String[] antwort;

    ///////////////////////////// Variant 1 -> mit Array/////////////////////////////////////////
    public Multiple_Choice_Fragen(String frage, String[] antwort) {
        super(frage);
        this.antwort = antwort;
    }
    ///////////////////////////// Variant 2 -> ohne Array/////////////////////////////////////////
    /*public Multiple_Choice_Fragen(String frage)
    {
        super(frage);
    }
     */
    @Override
    public void BuildBogen()
    {
        ///////////////////////////// Variant 1 - mit Array /////////////////////////////////////////
        StringBuilder builder = new StringBuilder();
        builder.append("Fragentext:").append("\n");
        builder.append(super.frage).append("\n");
        builder.append("Antwortmöglichkeiten:").append("\n");
        for (String string : antwort)
        {
            builder.append(string).append("\n");
        }
        System.out.println(builder);

        ///////////////////////////// Variant 2 - ohne Array/////////////////////////////////////////
       /*
        StringBuilder builder = new StringBuilder();
        String[] questions = super.frage.split("\n");
        builder.append("Fragentext:").append("\n");
        builder.append(questions[0]).append("\n").append("\n");
        builder.append("Antwortmöglichkeiten:").append("\n");

        for (int i = 1; i < questions.length; i++)
        {
            builder.append(questions[i]).append("\n");
        }
        System.out.println(builder);

        */
    }
}