package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String words = "Arbeiten,Laden,Fahren,Essen,Essen,Fahren.Laden,Fahren";

        LinkedHashMap<String, Integer> wordCount = countWords(words);
        LinkedHashMap<String, Integer> wordCount2 = countWordsButWithStreamAPI(words);
        System.out.println("Only with LinkedHashMap:");
        for (String s : wordCount.keySet()) {
            System.out.println(s + " -> " + wordCount.get(s));
        }
        System.out.println();
        System.out.println("With Stream-API:");
        for (String s : wordCount2.keySet()) {
            System.out.println(s + " -> " + wordCount2.get(s));
        }

        System.out.println();
        List<String> urls = Arrays.asList("http://example.com", "http://example.org");
        for (String url : urls) {
            try {
                String text = downloadWebPage(url);
                LinkedHashMap<String, Integer> webWordCount = countWordsButWithStreamAPI(text);
                System.out.println("Word count for " + url + ":");
                for (String s : webWordCount.keySet()) {
                    System.out.println(s + " -> " + webWordCount.get(s));
                }
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static LinkedHashMap<String, Integer> countWords (String words)
    {
        String[] parts = words.split("\\W+");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : parts) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
    private static LinkedHashMap<String, Integer> countWordsButWithStreamAPI (String words)
    {
        return Arrays.stream(words.split("\\W+")) // Split by non-word characters to handle spaces, commas, etc.
                .collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().intValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    private static String downloadWebPage(String url) throws IOException {
    Document doc = Jsoup.connect(url).get();
    return doc.body().text();
    }
}