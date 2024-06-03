package org.example;

public class Knoten<T>
{
    public T value;
    public Knoten<T> next;

    public Knoten(T value) {
        this.value = value;
    }
}
