package Klausurvorberaitung.Änderungen_an_Websiten_durch_Threads_beobachten;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        WebsiteChangeWatcher watcher =
                new WebsiteChangeWatcher("https://www.zeit.de", "campus",
                        consumer);

        Thread thread = new Thread(watcher);
        thread.start();
        try {
            Thread.sleep(120000);
            watcher.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
