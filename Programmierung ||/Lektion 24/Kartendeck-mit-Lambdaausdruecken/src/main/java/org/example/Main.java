package org.example;

public class Main {
    public static void main(String[] args) {

        Kartendeck kartendeck = new Kartendeck();
        kartendeck.erzeugeDeck();
        kartendeck.erzeugeDeckMitFlat();
        System.out.println(kartendeck);
    }
}