public class Main {
    public static void main(String[] args)
    {
        // a) Erzeugen Sie Türen mit ihrer Nummer, initial geschlossen
        Door[] doors = new Door[100];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(i + 1, false);
        }

        // b) Durchführung der einhundert Durchgänge
        for (int pass = 1; pass <= 100; pass++) {
            for (int door = pass - 1; door < doors.length; door += pass) {
                // Ändern Sie den Zustand der Tür
                doors[door].setOpen(!doors[door].isOpen());
            }

            // Ausgabe des Zustands aller Türen nach jedem Gang des Hausmeisters
            System.out.print("Nach Gang " + pass + ": ");
            for (int i = 0; i < doors.length; i++) {
                System.out.print(doors[i].toString());
            }
            System.out.println(); // Neue Zeile für den nächsten Durchgang
        }

        // c) Zählen Sie die geöffneten Türen am Ende
        int openDoorsCount = 0;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isOpen()) {
                openDoorsCount++;
            }
        }

        // Ausgabe der Anzahl der geöffneten Türen am Ende
        System.out.println("Anzahl der geöffneten Türen am Ende: " + openDoorsCount);
    }
}