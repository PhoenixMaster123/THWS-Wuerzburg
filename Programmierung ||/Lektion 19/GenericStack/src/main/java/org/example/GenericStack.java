package org.example;

import java.util.Stack;

public class GenericStack<T> {
     Knoten<T> start;
     Stack<T> list = new Stack<>();
    public void push(T element)
    {
        list.push(element);
    }

    public void push2(T element) {
        Knoten<T> newNode = new Knoten<>(element);
        newNode.next = start;
        start = newNode;
    }

    public T pop()
    {
        return list.pop();
    }

        public T pop2() {
        T value = start.value;
        start = start.next;
        return value;
    }

}
