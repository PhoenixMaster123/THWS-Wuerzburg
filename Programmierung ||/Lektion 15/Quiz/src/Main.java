public class Main {
    public static void main(String[] args) {

        Fragen textBogen = new TextFragen("Was ist die Hauptstadt von Deutschland?");
        textBogen.BuildBogen();
        ///////////////////////////// Variant 1 -> mit Array/////////////////////////////////////////
        Fragen multipleBogen = new Multiple_Choice_Fragen("Wie viele Protonen hat ein Wasserstoff-Atom?\n",
                new String[]{"A: 4\n" +
                        "B: 2\n" +
                        "C: 1\n" +
                        "D: 0"});
        multipleBogen.BuildBogen();


        ///////////////////////////// Variant 2 -> ohne Array/////////////////////////////////////////
        /*Fragen multipleBogen = new Multiple_Choice_Fragen("Wie hoch ist der Eiffelturm?\n" +
                "A: 150m\n" +
                "B: 176m\n" +
                "C: 220m\n" +
                "D: 300m\n");
        multipleBogen.BuildBogen();
         */
    }
}