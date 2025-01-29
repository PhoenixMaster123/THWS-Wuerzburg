package ChatGPT.Kino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");

        stringList.forEach(k -> System.out.println(k));

        Map<String, Integer> integerMap = new HashMap<>();

        integerMap.put("a", 1);
        integerMap.put("b", 2);

        integerMap.values().forEach(k -> System.out.println(k));

        integerMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
