public class SwitchAusdruckMitEnum
{
    public static boolean istWochenende(Wochentag wochentag) {
        return switch (wochentag) {
            case Montag, Dienstag, Mittwoch, Donnerstag, Freitag -> false;
            case Samstag, Sonntag -> true;
        };
    }
}
