public class Main {
    public static void main(String[] args) {

        // Create some Artikel instances
        Artikel artikel1 = new Artikel(1, "Laptop");
        Artikel artikel2 = new Artikel(2, "Smartphone");
        Artikel artikel3 = new Artikel(3, "Headphones");

        // Create a Bestellung instance and add Artikel to it
        Bestellung bestellung = new Bestellung(123);
        bestellung.einfuegen(artikel1);
        bestellung.einfuegen(artikel2);
        bestellung.einfuegen(artikel3);

        // Create a Kunde instance with the Bestellung
        Kunde kunde = new Kunde(new Bestellung[]{bestellung});

        // Use the giveBestellung method to find a Bestellung with a specific Artikel
        Bestellung foundBestellung = kunde.giveBestellung("Smartphone");

        // Print the result
        if (foundBestellung != null) {
            System.out.println("Bestellung gefunden: " + foundBestellung.getBestellnummer());
        } else {
            System.out.println("Artikel nicht gefunden in den Bestellungen des Kunden.");
        }
    }
}
