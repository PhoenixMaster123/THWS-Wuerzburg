package _01_Einführung.Übung_01a;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> coins = List.of(50,10,5,2,1);
        List<Integer> coins2 = List.of(11,7,1);
        Map<Integer, Integer> coinMap = new LinkedHashMap<>();
        Map<Integer, Integer> coinMap2 = new LinkedHashMap<>();


        coins.forEach(k -> coinMap.putIfAbsent(k, 0));
        coins2.forEach(k -> coinMap2.putIfAbsent(k, 0));


        coinProblem(n, coinMap);
        coinProblem(n, coinMap2);

        coinMap.values().forEach(k -> System.out.print("Coin: " + k + "\n"));
        int d = coinMap.values().size();
        System.out.println(d);

    }

    private static void coinProblem(int n, Map<Integer, Integer> coinMap) {
        for (Integer key : coinMap.keySet()) {
            while (n >= key)
            {
                n -= key;
                coinMap.put(key, coinMap.get(key) + 1);
            }
        }
    }
}