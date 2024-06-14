package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> bBrothers = Arrays.asList("Burt", "Bronski", "Peter");
        List<String> collect = bBrothers.parallelStream()
                .filter(name -> name.startsWith("B"))
                .collect(Collectors.toList());
        System.out.println(collect);

        "Hello World".chars().parallel().forEach(c -> System.out.print((char) c));

    }
}