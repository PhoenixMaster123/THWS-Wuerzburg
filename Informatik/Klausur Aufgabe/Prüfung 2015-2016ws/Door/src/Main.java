public class Main {
    public static void main(String[] args) {
        Door door1 = new Door(1, true);  // Tür mit Nummer 1, offen
        Door door2 = new Door(2, false); // Tür mit Nummer 2, geschlossen

        System.out.println("Door 1: " + door1.toString()); // Erwartete Ausgabe: "Door 1: o"
        System.out.println("Door 2: " + door2.toString()); // Erwartete Ausgabe: "Door 2: z"
    }
    }
