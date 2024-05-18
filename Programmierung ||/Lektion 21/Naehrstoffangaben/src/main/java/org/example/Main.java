package org.example;

public class Main {
    public static void main(String[] args)
    {
        Naehrstoffangaben angaben = new Naehrstoffangaben.NaehrstoffangabenBuilder
                (148, 5)
                .withEiweiss(20.5).withFett(10.4).withKohlenhydrate(3.5).
                withNatrium(0.6).build();

        System.out.println(angaben);
    }
}