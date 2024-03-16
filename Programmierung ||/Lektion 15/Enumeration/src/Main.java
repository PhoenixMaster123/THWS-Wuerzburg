import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Wochentag wochentag = Wochentag.Freitag;

        ////////////////////////////// Kurz Variant /////////////////////////
        //System.out.println(Wochentag.values()[(wochentag.ordinal() + 5) % 7]);
        Wochentag[] wochentage = Wochentag.values();
        int enumIndexDesAktuellenWochentags = wochentag.ordinal();
        int enumIndexIn5Tagen = (enumIndexDesAktuellenWochentags + 5) % 7;
        System.out.println(wochentage[enumIndexIn5Tagen]);

        String eingabe = new Scanner(System.in).nextLine();
        Wochentag w = Wochentag.valueOf(eingabe);
        System.out.println(SwitchAusdruckMitEnum.istWochenende(w));

    }
}