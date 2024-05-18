package org.example;

public class Main {
    public static void main(String[] args) {

        Binaerbaum baum = new Binaerbaum();
        Binaerbaum.Knoten k;
        k = new Binaerbaum.Knoten("Cool");
        baum.insert(k);
        k = new Binaerbaum.Knoten("Zylla");
        baum.insert(k);
        k = new Binaerbaum.Knoten("Aaronson");
        baum.insert(k);
        k = new Binaerbaum.Knoten("Garrett");
        baum.insert(k);

        baum.printForward();
    }
}