import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int durchmesser1 = Integer.parseInt(sc.nextLine());
        double preis1 = Double.parseDouble(sc.nextLine());
        int durchmesser2 = Integer.parseInt(sc.nextLine());
        double preis2 = Double.parseDouble(sc.nextLine());

        double flaeche1 = Math.pow(durchmesser1 / 2.0, 2) * Math.PI;
        double flaeche2 = Math.pow(durchmesser2 / 2.0, 2) * Math.PI;

        double groessenPreisVerhaeltnis1 = flaeche1 / preis1; //
        double groessenPreisVerhaeltnis2 = flaeche2 / preis2; // 

        if (groessenPreisVerhaeltnis1 > groessenPreisVerhaeltnis2) {
            System.out.printf("Pizza 1 hat bessere Größen‐/Preisverhältnis: %.2f", groessenPreisVerhaeltnis1);
        } else {
            System.out.printf("Pizza 2 hat bessere Größen‐/Preisverhältnis: %.2f", groessenPreisVerhaeltnis2);
        }
    }
}
