package org.example;

import java.net.URL;
import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("Normal back");
            Browser browser = new Browser();
            Optional<URL> back = browser.back();
            // Changing the attribute to Optional<URL>
           /* if(!back.isEmpty())
            {
                browser.retrieveSite(back);
            }
            // Without changing the attribute to Optional<URL>
            back.ifPresent(browser::retrieveSite2);
            */
            System.out.println("Present?");
            if(back.isPresent())
            {
                System.out.println(browser.retrieveSite(back.get()));
            }
            System.out.println("Lambda -> Consumer kurz");
            back.ifPresent(x -> System.out.println(browser.retrieveSite(x)));

            System.out.println();
            System.out.println("Consumer lang");

            Consumer<URL> consumer = new Consumer<URL>() {
                @Override
                public void accept(URL url) {
                    System.out.println(browser.retrieveSite(url));
                }
            };

            back.ifPresent(consumer);
        }
    }
}