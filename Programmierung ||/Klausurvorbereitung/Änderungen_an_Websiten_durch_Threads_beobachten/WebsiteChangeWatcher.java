package Klausurvorberaitung.Änderungen_an_Websiten_durch_Threads_beobachten;

import java.util.Scanner;
import java.util.function.Consumer;

public class WebsiteChangeWatcher implements Runnable {
    private String target;
    private String path;
    Consumer<String> consumer;
    boolean cancel;
    
    public WebsiteChangeWatcher(String target, String path, Consumer<String> consumer) {
        this.target = target;
        this.path = path;
        this.consumer = consumer;
        this.cancel = false;
    }
    @Override
    public void run() {
        while (!this.cancel) {
            hasChanged();
        }
    }
    public void cancel() {
        this.cancel = true;
    }

    public void hasChanged() {
        try {
            String content = retrieveWebsiteContent();
            Thread.sleep(30000);
            String newContent = retrieveWebsiteContent();

            if(!content.equals(newContent)) {
                consumer.accept(newContent);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String retrieveWebsiteContent() {
        return null;
    }
}
