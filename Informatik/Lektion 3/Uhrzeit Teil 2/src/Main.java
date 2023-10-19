import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stunden = Integer.parseInt(sc.nextLine());
        int minuten = Integer.parseInt(sc.nextLine());
        int sekunden = Integer.parseInt(sc.nextLine());
        if(sekunden >= 60)
        {
            sekunden %= 60;
            minuten++;
        }
        if(minuten >= 60)
        {
            minuten %=60;
            stunden++;
        }
        if(stunden > 23)
        {
            stunden = 0;
        }
        System.out.printf("%02d:%02d:%02d\n", stunden, minuten, sekunden);
    }
}