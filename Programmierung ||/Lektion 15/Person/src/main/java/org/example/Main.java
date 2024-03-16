package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[100];

        Random random = new Random();
        for (int i = 0; i < people.length; i++)
        {
           if(random.nextBoolean())
           {
               people[i] = new Student();
               System.out.println(people[i].gibTaetigkeitAus("Programmieren"));
           }
           else
           {
               people[i] = new Professor();
               System.out.println(people[i].gibTaetigkeitAus("Programmieren"));
           }
        }
    }
}