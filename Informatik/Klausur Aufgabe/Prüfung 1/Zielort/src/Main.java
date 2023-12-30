public class Main {
    public static void main(String[] args) {

        Fahrstrecke fahrstrecke = new Fahrstrecke();
        fahrstrecke.einfuegen("Würzburg", 0);
        fahrstrecke.einfuegen("Kitzingen", 19);
        fahrstrecke.einfuegen("Neustadt", 42);
        fahrstrecke.einfuegen("Nürnberg", 49);

        System.out.println(fahrstrecke.gesamtStrecke());
    }
}