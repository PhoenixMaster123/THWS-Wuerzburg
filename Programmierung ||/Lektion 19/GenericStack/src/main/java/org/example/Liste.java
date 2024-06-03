package org.example;

import java.util.ArrayList;

public class Liste<E>
{
    ArrayList<E> list = new ArrayList<>();
    Knoten<E> start;
    Knoten<E> ende;

    ///////////////////////////////////// Variant 2 ////////////////////
    public void add2(E element)
    {
            if (element == null) return;
            Knoten<E> k = new Knoten<>(element);
            if (start == null) {
                start = k;
                ende = start;
            } else {
                ende.next = k;
                ende = k;
            }
    }
    ///////////////////////////////////// Variant 1 //////////////////////
    public void add(E element)
    {
        list.add(element);
    }
}
