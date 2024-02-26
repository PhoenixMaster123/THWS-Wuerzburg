import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Hund> hundeList = new ArrayList<>();
        System.out.println("Unser Tierheim hat viele Hunde");

        ThreadMaker.lassImHintergrundLaufen(() -> {
            for (int i = 0; i < 1000; i++) {
                Hund hund = new Hund("Tom" + i);
                hundeList.add(hund);
            }
        });


        System.out.println("Das sind unsere Hunde:");
        for (Hund hund : hundeList) {
            System.out.println(hund.getName());
        }


        /*
        MyThreads thread = new MyThreads();
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();

         */
    }
}