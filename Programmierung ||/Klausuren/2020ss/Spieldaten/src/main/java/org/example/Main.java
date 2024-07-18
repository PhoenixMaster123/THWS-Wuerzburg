package org.example;

public class Main {
    public static void main(String[] args) {
        Spieldaten.SpieldatenBuilder builder = new Spieldaten.SpieldatenBuilder();
        Spieldaten daten = builder.geld(1000)
                .add("abc")
                .add("xyz")
                .build();

        System.out.println("Geld: " + daten.geld);
        System.out.println("Spieler IDs: " + daten.getSpielerIDs());

       //  This will throw UnsupportedOperationException
         daten.getSpielerIDs().add("bla");

    }
}