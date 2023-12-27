public class Main {
    public static void main(String[] args) {

        Punkt p = new Punkt(2,5,7);
        Punkt p2 = new Punkt(3,6,9);
        System.out.println(p.berechneAbstand(p.a, p.b, p.c));
        System.out.println(p);
        System.out.println(p.berechneAbstand(p2.a,p2.b,p2.c));
        System.out.println(p2);
    }
}