
public class Main {
    static final double DICHTE = 0.8;

    public static void main(String[] args) {
        double v = 1000;
        double e = 0.05;
        double masse = berechneMasse(v,e);
        System.out.println("Die Masse des Biers ist " + masse);
        double konzentration = berechneAlkKonzentration(masse, 70,'m');
        if (konzentration >= 0.5)
        {
            System.out.println("Sie dürfen kein Auto mehr fahren!!!");
        } else if (konzentration < 0.5 && konzentration >= 0.3)
        {
        System.out.println("Sie sollten kein Auto mehr fahren!!!");
        }

    }

    public static double berechneMasse(double volumen, double alkoholvolumenanteil) {
        return volumen * DICHTE * alkoholvolumenanteil;
    }

    public static double berechneAlkKonzentration(double masse, int gewicht, char geschlecht) {
        double konzentration = 0;
        double reduktion = 0;

        if (geschlecht == 'm') {
            reduktion = 0.7;
        } else if (geschlecht == 'f') {
            reduktion = 0.6;
        } else if (geschlecht == 'j') {
            reduktion = 0.5;
        } else {
            System.out.println("Invalid gender/age type");
            return -1;
        }

        konzentration = masse / (gewicht * reduktion);
        return konzentration;
    }
}
