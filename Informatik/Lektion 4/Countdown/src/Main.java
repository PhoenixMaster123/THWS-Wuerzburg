import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        for (int i = 15; i >= 0; i--) {

            System.out.println(i);
        }
        try {
            Thread.sleep(2000); // Pausiere für 2 Sekunden (2000 Millisekunden)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}