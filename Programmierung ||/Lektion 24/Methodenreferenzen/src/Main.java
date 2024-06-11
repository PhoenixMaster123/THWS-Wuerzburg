import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> bBrothers = Arrays.asList("Burt", "Bronski", "Peter");

        // without using name -> name.toUpperCase....
        bBrothers.stream()
                //Unbound method references
                //Die Referenz ist nicht an ein Objekt gebunden. Der Aufruf erfolgt
                //auf dem (von map) übergebenen Objekt.
                .map(String::toUpperCase).
                // Bound method reference
                forEach(System.out::println);

        // Bound method references ⇾ die Referenz ist an eine Methode (println) eines konkreten Objekts
        //(out) gebunden. Der String wird (von forEach) als Argument an die
        //println-Methode übergeben.

        List<String> lines = Files.readAllLines(new File("numbers.txt").toPath());
        lines.stream()
                //Static method references
                .map(Integer::valueOf)
                .forEach(i -> System.out.println(i));

        //Die Referenz ist an eine statische Methode gebunden. Wie bei bound
        //method references, wird (von map) das Objekt (der String) als
        //Argument an die statische Methode (valueOf von Integer)
        //weitergereicht.

        // Class Constructor reference ->
        List<String> collect = bBrothers.parallelStream()
                .filter(name -> name.startsWith("B"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(collect);

        Function<Integer, String[]> createStringArray = size -> new String[size];
        String[] s = createStringArray.apply(5);
        Arrays.stream(s).forEach(System.out::println);
        Function<Integer, String[]> createStringArray2 = String[]::new;
        String[] s2 = createStringArray.apply(5);

        Function<Integer, String[][]> create2DStringArray = size -> new String[size][];
        String[][] s3 = create2DStringArray.apply(3);
        Function<Integer, String[][]> create2DStringArray2 = String[][]::new;
        String[][] s4 = create2DStringArray.apply(3);

        BiFunction<Integer, Integer, String[][]> create2DStringArray3
                = (rows, cols) -> new String[rows][cols];
        String[][] s5 = create2DStringArray3.apply(2,3);

    }
}