
public class Main {
    public static void main(String[] args) {

        if(args.length !=2)
        {
            System.out.println("Geben Sie genau zwei zahlen als Argumente");
            return;
        }
        try {


            String zahl1 = args[0];
            String zahl2 = args[1];

            int multiplikation = Integer.parseInt(zahl1) * Integer.parseInt(zahl2);
            System.out.println("Die Ergebnis der Multiplikation ist: " + multiplikation);
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Bitte geben Sie gültige Zahlen als Argumente ein.");
        }
    }
}