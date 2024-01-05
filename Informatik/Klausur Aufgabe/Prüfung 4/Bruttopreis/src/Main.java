import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double bruttoPreis = 1.07;
        double mehrwertSteuersatz = 0.07;

        double nettoPreis = berechneNettopreis(bruttoPreis,mehrwertSteuersatz);

        System.out.println(nettoPreis);

        System.out.println("Der Nettopreis beträgt: " + nettoPreis + " EUR");

        
    }


    static public double berechneNettopreis(double brutto, double mehrwert)
    {
        double netto = brutto / (mehrwert * 1 + 1);
        return netto;
    }


}