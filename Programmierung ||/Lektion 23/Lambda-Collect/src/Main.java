import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args)
    {
        // The result need to be stored in new Collection

        // The collect methode need 3 Parameter:
        //-> ein Supplier(example: List)
        //-> ein Accumulator -> explains how the elements from the container are collected
        //-> ein Combiner, der beschreibt wie bei paraller Verarbeitung Teilcontainer zusammengelegt werden.

        //Supplier
        List<String> bBrothers = Arrays.asList("Burt","Bronski","Peter");

        /* Long Version and hard
        List<String> list = bBrothers.stream().
                filter(name -> name.startsWith("B")).
                collect(() -> new ArrayList<>(), (l,name) -> l.add(name), (l1,l2) -> l1.addAll(l2));
         */
        // Short Version
        List<String> list = bBrothers.stream().filter(name -> name.startsWith("B")).collect(Collectors.toList());
        // Shorter Version -> we import java.util.stream.Collectors;
        List<String> list2 = bBrothers.stream().filter(name -> name.startsWith("B")).collect(toList());
        System.out.println(list);

        String nameListe = bBrothers.stream().filter(name -> name.startsWith("B")).collect(Collectors.joining(", "));
        System.out.println(nameListe);

        // Long Variant - How funktion collect
       /* List<String> list = bBrothers.stream().
                filter(name -> name.startsWith("B"))
                .collect(new Supplier<ArrayList<String>>() {
                             @Override
                             public ArrayList<String> get() {
                                 return new ArrayList<>();
                             }

                             ;
                         },
                        //Accumulator
                        new BiConsumer<ArrayList<String>, String>() {
                            @Override
                            public void accept(ArrayList<String> l, String name) {
                                l.add(name);
                            }
                        },
                        // Combiner
                        new BiConsumer<ArrayList<String>, ArrayList<String>>() {
                            @Override
                            public void accept(ArrayList<String> l, ArrayList<String> name)
                            {
                                l.addAll(name);
                            }
                        });
        */
    }
}
