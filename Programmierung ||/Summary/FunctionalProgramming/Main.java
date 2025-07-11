package summary.FunctionalProgramming;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Consumer + .accept
        Consumer<String> consumer = System.out::println;

        consumer.accept("Hello World");

        // Supplier + .get
        Supplier<Integer> supplier = () -> new Random().nextInt(51);

        // Predicate + .test
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(6));

        consumer.accept(String.valueOf(supplier.get()));

        // Function + .apply
        Function<String, String> func = k -> {
            return k.toUpperCase();
        };
    }
}
