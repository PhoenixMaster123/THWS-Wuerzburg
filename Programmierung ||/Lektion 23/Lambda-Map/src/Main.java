import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        ////////////////////////////// Map //////////////////////////////
        List<String> bBrothers = Arrays.asList("Burt","Bronski","Peter");
        bBrothers.stream().map(name -> name.toUpperCase()).
                 forEach(name -> System.out.println(name));

        // When I have more than one Index example (name, ...) then I need to add {return ...}
        bBrothers.stream().map(name -> name.length()). //<String,Integer>
                forEach(count -> System.out.println(count));

        // Another Example - find the longest name
        Optional<String> longestName = bBrothers.stream()
                .max(Comparator.comparingInt(String::length)); // Find the longest name

        longestName.map(String::toUpperCase) // Convert to uppercase
                .ifPresent(System.out::println); // Print if present


        ////////////////////////////// Filter ///////////////////////////
        //Example: check how many brothers starts with B -> 2
        long totalOfRealBBrothers = bBrothers.stream().count();
        long numberOfRealBrothers = bBrothers.stream().filter(name -> name.startsWith("B")).count();
        if(numberOfRealBrothers < totalOfRealBBrothers)
        {
            System.out.println("Alarm! B-Brothers are: " + numberOfRealBrothers);
        }

        Consumer<String> printOut = name -> System.out.println();
            //Doppelt Code
           // Predicate<String> pFilter = name -> name.startsWith("P");
          // Predicate<String> bFilter = name -> name.startsWith("B");
         // Better Version + Method
        // Predicate<String> pFilter = letterFilter("P");
       // Predicate<String> bFilter = letterFilter("B");
      // Better better Version in absoluter Kurzform

        Function<String, Predicate<String>> letterFilter = letter -> (name -> name.startsWith(letter));
        bBrothers.stream().filter(letterFilter.apply("P")).forEach(printOut);
        bBrothers.stream().filter(letterFilter.apply("B")).forEach(printOut);
    }
    /*public static Predicate<String> letterFilter(String letter)
    {
        return name -> name.startsWith(letter);
    }
     */
   /* private static Predicate<String> letterFilter(String letter)
    {
        return name -> name.startsWith(letter);
    }
    */
}