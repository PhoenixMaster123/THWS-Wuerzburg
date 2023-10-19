import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        /////////////////////////// Variant 1 /////////////////////////////
        Scanner sc = new Scanner(System.in);

        // a) Anzahl der Sekunden seit Mitternacht

        LocalTime now = LocalTime.now();
        int stunden = now.getHour();
        int minuten = now.getMinute();
        int sekunden = now.getSecond();
        int sekundenSeitMitternacht = stunden * 3600 + minuten * 60 + sekunden;

        System.out.println("Sekunden seit Mitternacht: " + sekundenSeitMitternacht);

        // b) Verbleibende Sekunden für diesen Tag

        int verbleibendeSekunden = 24 * 3600 - sekundenSeitMitternacht;
        System.out.println("Verbleibende Sekunden für diesen Tag: " + verbleibendeSekunden);

        // c) Prozent des Tages, die schon vergangen sind

        double prozentVergangen = ((double) sekundenSeitMitternacht / (24 * 3600)) * 100;
        System.out.printf("Prozent des Tages, die schon vergangen sind: %.2f%%\n", prozentVergangen);

        /////////////////////////// Variant 2 - Uhrzeit now /////////////////////////////
        SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss");
        System.out.println(date.format(new Date()));
        /////////////////////////// Variant 3 ////////////////////////////////////////////
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime); // Stunden:Minuten:Sekunden:Millisekunden
        ////////////////////////// Variant 4 - Ohne Millisekunden ////////////////////////
        LocalTime currentTime2 = LocalTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(pattern);
        System.out.println(formattedTime);
    }
}