import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String monat = scanner.nextLine();
        System.out.println(tageImMonat((monat)));
    }
    public static int tageImMonat (String monat)
    {
        int tage = switch (monat)
        {
            case "Februar" -> 28;
            case "April", "Juni","September", "November" -> 30;
            case "Januar", "März", "Mai", "Juli", "August", "Oktober", "December" -> 31;
            default -> throw new RuntimeException("falscher Monatsname");
        };
        return tage;
    }
}