package _02_Listen_Stacks_Queues.Übung_02c;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SmartArray {

    private Candle[] data;
    private int size;
    private int capacity;

    private static final double SMALL_THRESHOLD = 0.0001;  // Toleranz für kleine Werte
    private static final double LARGE_THRESHOLD = 0.001;   // Schwelle für den langen unteren Schatten

    public SmartArray() {
        this.size = 0;
        this.capacity = 1;
        this.data = new Candle[capacity];
    }
    public Candle get(int index) {
        return this.data[index];
    }
    public int size() {
        return this.size;
    }
    public void add(Candle element) {
        if(this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        Candle[] newArray = new Candle[this.data.length * 2];
        this.capacity = newArray.length;
        for (int index = 0; index < this.data.length; index++) {
            newArray[index] = this.data[index];
        }
        this.data = newArray;
    }

    public Candle getLast() {
        if(size == 0) {
            return null;
        }
        return this.data[size - 1];
    }
    public int search(Candle targetCandle) {
        for (int i = 0; i < size; i++) {
           Candle currentCandle = this.data[i];

           if(currentCandle.body() == targetCandle.body() &&
              currentCandle.head() == targetCandle.head() &&
              currentCandle.tail() == targetCandle.tail()) {

               System.out.println("Body: " + (int) (currentCandle.body() * 10000) + " pips");
               System.out.println("Head: " + (int) (currentCandle.head() * 10000) + " pips");
               System.out.println("Tail: " + (int) (currentCandle.tail() * 10000) + " pips");

               return i;
           }
        }
        return -1;
    }
    public void loadFile(String fname) {
        int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String line;

            while((line = br.readLine()) != null) {
                if(counter == 0) {
                    counter++;
                    continue;
                }
                String[] tokens = line.split("\t");
                String timestamp = tokens[0];
                double open = Double.parseDouble(tokens[1]);
                double high = Double.parseDouble(tokens[2]);
                double low = Double.parseDouble(tokens[3]);
                double close = Double.parseDouble(tokens[4]);
                int volume = Integer.parseInt(tokens[5]);

                Candle candle = new Candle(timestamp,open,high,low, close,volume);
                this.add(candle);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isDragonflyDoji(Candle candle) {
        return Math.abs(candle.getOpen() - candle.getClose()) < SMALL_THRESHOLD && // Open und Close fast gleich
                (candle.getHigh() - Math.max(candle.getOpen(), candle.getClose())) < SMALL_THRESHOLD && // Kleiner Kopf
                (Math.min(candle.getOpen(), candle.getClose()) - candle.getLow()) > LARGE_THRESHOLD; // Langer unterer Schatten
    }

    // Überprüfung, ob der Kurs nach einer Dragonfly-Doji-Kerze steigt
    public boolean isRising(Candle currentCandle, Candle nextCandle) {
        return nextCandle.getClose() > currentCandle.getClose();
    }

    // Methode zum Zählen und Überprüfen der Behauptung
    public void checkDragonflyDojiPattern() {
        int dragonflyCount = 0;
        int risingAfterDragonfly = 0;

        for (int i = 1; i < this.size() - 1; i++) {
            Candle currentCandle = this.get(i);
            Candle nextCandle = this.get(i + 1);

            if (isDragonflyDoji(currentCandle)) {
                dragonflyCount++;
                if (isRising(currentCandle, nextCandle)) {
                    risingAfterDragonfly++;
                }
            }
        }

        if (dragonflyCount > 0) {
            System.out.println("Anzahl der Dragonfly-Doji Kerzen: " + dragonflyCount);
            System.out.println("Anzahl gestiegener Kurse nach Dragonfly-Doji: " + risingAfterDragonfly);
            System.out.println("Prozentsatz der gestiegenen Kurse: " + ((double) risingAfterDragonfly / dragonflyCount) * 100 + "%");
        } else {
            System.out.println("Keine Dragonfly-Doji Kerzen gefunden.");
        }
    }

}

