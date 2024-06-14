package org.example;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        // Doesn't look good
        List<String> urls = Arrays.asList(
                "https://en.wikipedia.org/wiki/Donald_Trump",
                "https://en.wikipedia.org/wiki/Angela_Merkel",
                "https://en.wikipedia.org/wiki/Vladimir_Putin");
        urls.parallelStream()
                .map(url -> {
                    try {
                        return Jsoup.connect(url)
                                .get()
                                .text();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        // Better
        List<String> urls2 = Arrays.asList(
                "https://en.wikipedia.org/wiki/Donald_Trump",
                "https://en.wikipedia.org/wiki/Angela_Merkel",
                "https://en.wikipedia.org/wiki/Vladimir_Putin");
        urls2.parallelStream()
                .map(ThrowingFunction.unchecked(url ->
                        Jsoup.connect(url)
                                .get()
                                .text()));

    }
}