package Klausurvorberaitung.ss2020.Aufgabe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Konfigurator {
    public static List<String> liesKongurationsdatei() throws IOException {
        List<String> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new java.io.FileReader("C:\\Users\\krisi\\OneDrive\\Desktop\\Informatik\\Semester 2\\Programmierung 2 SS\\Programmierung 2 SS\\src\\main\\java\\Klausurvorberaitung\\ss2020\\datei.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }

    public Map<String, String> transformiereKonfiguration() {
        Map<String, String> map = new LinkedHashMap<>();

        try {
            List<String> list = liesKongurationsdatei();
            for (String s : list) {
                String[] split = s.split("=");
                map.put(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
