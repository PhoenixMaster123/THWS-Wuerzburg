package org.example;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class Person implements Serializable
{
    String vorname;
    String nachname;
    int age;
    public Person(String vorname, String nachname, int age)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{vorname = '" + vorname + "| nachname: " + nachname + "| age: " + age + "}";
    }
}
