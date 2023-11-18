import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int distanz = scanner.nextInt();
        int spungweit1 = scanner.nextInt();
        int sprungweit2 = scanner.nextInt();

        System.out.println(springeInMehrerenSpruengen(distanz,spungweit1,sprungweit2));
        scanner.close();

    }

    private static int springeInMehrerenSpruengen(int distanz, int spungweit1, int sprungweit2)
    {
        int zweiteDistanz = distanz;

        if(distanz == 0)
        {
            return 1;
        }
        else if(distanz > 0)
        {
            distanz-=spungweit1;
            zweiteDistanz -=sprungweit2;
            return springeInMehrerenSpruengen(zweiteDistanz,spungweit1,sprungweit2) + springeInMehrerenSpruengen(distanz,spungweit1,sprungweit2);
        }
        return 0;
    }
}