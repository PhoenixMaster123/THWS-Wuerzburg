package org.example;

public class Main {
    public static void main(String[] args)
    {
        Baum<Integer> baum = new Baum<>();
        baum.einfuegen(5);
        baum.einfuegen(3);
        baum.einfuegen(7);
        baum.einfuegen(2);
        baum.einfuegen(4);
        baum.einfuegen(6);
        baum.einfuegen(8);

        System.out.println("Anzahl der Knoten im Baum: " + baum.size());
    }
}