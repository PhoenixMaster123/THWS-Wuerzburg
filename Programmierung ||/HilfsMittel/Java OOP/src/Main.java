import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // Interfaces

        // Functional Interface:

        // Integer -> Parameter, Integer -> Rückgabewert
        Function<Integer,Integer> addTwoMethod = number -> number + 2;
        Function<Integer,Integer> multThree = number -> number * 3;
        int result = addTwoMethod.compose(multThree).apply(4);
        System.out.println(result);

        // Consumer Interface

        Consumer<String> swem = s -> System.out.println(s + "!");
        swem.accept("Hallo");

        List<String> students = List.of("Peter", "Marie", "Paul");
        students.forEach(swem);

        //Predicate Interface

        Predicate<String> studentTest = student -> student.startsWith("M");
        System.out.println(studentTest.test(students.get(1)));

        // Supplier Interface:

        Supplier<Double> random1000 = () -> Math.random() * 1000;
        System.out.println(random1000.get());

    }
    public static int addTwoMethod(int number)
    {
        return number;
    }











       /* // Anonum Klasse - erweitern

        Katze katze = new Katze() {
            public void macheMial() {
                System.out.println("Meow");
            }
        };
        katze.macheMial();

        // interface

        Lebewesen_2 monkey = new Lebewesen_2() {
            @Override
            public void macheEtwas() {
                System.out.println("Uhh Ahh");
            }
        };
        monkey.macheEtwas();

        rufeMethodeAuf(monkey);
    }
    public static void rufeMethodeAuf(Lebewesen_2 lebewesen)
    {
        lebewesen.macheEtwas();
    }

        */





        /*
        Fahrzeug auto = new Auto();
        auto.fahren(); // -> method Auto -> Brum Brum
        System.out.println(auto.getGeschwiendigkeit());

         */



        /*
        Kunde kunde = new Kunde("Kris", 21,"krisi_popov2003@gmail.com","+49896734997");
        Kunde kunde1 = new Kunde("Lea", 20);
        Kunde kunde2 = new Kunde();

        Pflanze pflanze = new Pflanze(100,10.5,false); // Zuerst Superklasse danach Unterklasse
        System.out.println(pflanze.alter);

        Baum baum = new Baum(100,5.4,false,1000);

         */

}