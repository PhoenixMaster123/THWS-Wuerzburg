package org.example;

public class Main {
    public static void main(String[] args) {

        Binaerbaum<String> baum = new Binaerbaum<>();
        baum.insert(new Binaerbaum.Knoten<>("Cool"));
        baum.insert(new Binaerbaum.Knoten<>("Zylla"));
        baum.insert(new Binaerbaum.Knoten<>("Aaronson"));
        baum.insert(new Binaerbaum.Knoten<>("Garrett"));

        Binaerbaum<Integer> baum2 = new Binaerbaum<>();
        baum2.insert(new Binaerbaum.Knoten<>(2));
        baum2.insert(new Binaerbaum.Knoten<>(3));
        baum2.insert(new Binaerbaum.Knoten<>(6));
        baum2.insert(new Binaerbaum.Knoten<>(4));

        baum.printForward();

        baum2.printForward();
    }
}
