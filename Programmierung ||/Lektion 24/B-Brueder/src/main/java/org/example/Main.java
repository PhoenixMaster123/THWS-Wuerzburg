package org.example;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main
{
    // ToDo -> Not exactly sure about the both average methods
    public static void main(String[] args)
    {
        List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311),
                new BBruder("Bronski", 200, 274),
                new BBruder("Bruno", 236, 328));

    reduce(bBrothers);
    reduceAvg(bBrothers);
    reduceWithJoining(bBrothers);

    }
    //a)
    public static void reduce(List<BBruder> bBruders)
    {
        Optional<String> result = bBruders.stream().map(BBruder::toString)
                .reduce((name1,name2) -> name1 + "," + name2);

        result.ifPresent(System.out::println);
    }
    public static void reduceAvg(List<BBruder> bBruders)
    {
        OptionalDouble result = bBruders.stream().mapToDouble(p -> p.bankDrueckenGewicht)
                .average();
        result.ifPresent(System.out::println);
    }
    public static void reduceWithJoining(List<BBruder> bBruders)
    {
        Optional<String> result = Optional.ofNullable(bBruders.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        result.ifPresent(System.out::println);
    }
    public static void reduceAvgWithDoubleStream(List<BBruder> bBruders)
    {
        OptionalDouble result = bBruders.stream().mapToDouble(p -> p.bankDrueckenGewicht)
                .average();
        result.ifPresent(System.out::println);
    }
}

