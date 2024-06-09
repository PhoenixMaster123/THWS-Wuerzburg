import java.awt.*;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Circle c2 = new Circle(4);
        Circle[] circles = new Circle[]{c,c2};

        Consumer<Shape> consumer = new Consumer<Shape>() {
            @Override
            public void accept(Shape shape)
            {
                System.out.println(shape.calculateArea());
            }
        };
        Stream<Circle> stream = Arrays.stream(circles);
        stream.forEach(consumer);

        Square s = new Square(5);
        Square s2 = new Square(4);
        Square[] squares = new Square[]{s,s2};

        /*
        Consumer<Shape> consumer2 = new Consumer<Shape>() {
            @Override
            public void accept(Shape shape)
            {
                System.out.println(shape.calculateArea());
            }
        };
         */
        Stream<Square> stream2 = Arrays.stream(squares); // To Use the functions from stream I need to make the array generic
        stream2.forEach(consumer);

        // I don't need second consumer, bc Square and Circle are subclasses from Shape
        // If I change the in Consumer to Square then I need two Consumer one for Square and one for Circle
        // Another Example is Comparator

        // Consumer + Lambda -> short version
        Consumer<Shape> consumer2 = shape -> System.out.println(shape.calculateArea());


    }
}