import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int r = Integer.parseInt(sc.nextLine());

        double kreisflach = Math.PI *  (r * r); // Math.pow(r,2)
        double kreisumfang = Math.PI * 2 * r; // leichter zu lesen
        double volume = (4.0/3.0 * Math.PI * (r * r * r)); //Math.pow(r, 3))

        System.out.println(kreisflach);
        System.out.println(kreisumfang);
        System.out.println(volume);

    }
}
