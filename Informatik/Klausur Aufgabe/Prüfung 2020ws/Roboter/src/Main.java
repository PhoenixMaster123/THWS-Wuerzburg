public class Main {
    public static void main(String[] args) {
        // Erstelle einen Roboter namens R2D2, der 96 cm groß ist
        Roboter r2d2 = new Roboter("R2D2", 96);

// Erstelle einen Roboter namens WALL-E, der 112 cm groß ist
        Roboter wall_e = new Roboter("WALL-E", 112);

// Erstelle einen Roboter namens Optimus Prime, der 1100 cm groß ist
        Roboter optimus_prime = new Roboter("Optimus Prime", 1100);

// Erstelle eine Polonaise mit den drei Robotern
        Polonaise polonaise = new Polonaise();

// Füge die Roboter nach ihrer Größe sortiert in die Polonaise ein
        polonaise.anhaengen(r2d2.getName(), r2d2.getGross());
        polonaise.anhaengen(wall_e.getName(), wall_e.getGross());
        polonaise.anhaengen(optimus_prime.getName(), optimus_prime.getGross());

// Lasse die Roboter sich in der Polonaise vorstellen
        polonaise.vorstellen();

    }
}