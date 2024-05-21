import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Unbounded Wildcard (<?>): When the type parameter can be any type.
        Upper Bounded Wildcard (<? extends Type>): When the type parameter must be of a certain type or its subclass.
        Lower Bounded Wildcard (<? super Type>): When the type parameter must be of a certain type or its superclass.
         */

        // With classes
        List<Person> list = Arrays.asList(new Person("Joe", "Cool"),
                new Person("Steffen", "Heinzl"));

        MyList<Person> personen = new MyList<>();
        personen.addAll(list);

        System.out.println(personen);

        List<Dozent> listDozenten = Arrays.asList(new Dozent("Joe", "Cool", "Verteilte Systeme"),
                                                  new Dozent("Steffen", "Heinzl", "Programmieren"));

        MyList<Dozent> dozenten = new MyList<>();
        dozenten.addAll(listDozenten);

        System.out.println(dozenten);

        ////////////////////////////////////////// Examples ////////////////////////////////////

        /*
         Unbounded Wildcard (<?>): When the type parameter can be any type.
         Upper Bounded Wildcard (<? extends Type>): When the type parameter must be of a certain type or its subclass.
         Lower Bounded Wildcard (<? super Type>): When the type parameter must be of a certain type or its superclass.
        */
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        List<Number> numbers = new ArrayList<>();

        // Unbounded wildcard example
        printList(integers);
        printList(doubles);

        System.out.println();
        
        // Upper bounded wildcard example
        System.out.println("Sum of integers: " + sumOfNumbers(integers));
        System.out.println("Sum of doubles: " + sumOfNumbers(doubles));

        // Lower bounded wildcard example
        addNumbers(numbers);
        System.out.println("Numbers after adding elements: " + numbers);
    }
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
    }

    public static double sumOfNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}