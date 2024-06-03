package org.example;

public class Main {
    public static void main(String[] args) {
        GenericStack<String> s = new GenericStack<>();
        s.push("Hallo");
        s.push("Welt");

        ////////////////////////////////// Stack ///////////////////////////////////
        System.out.println(s.pop());
        System.out.println(s.pop());

        GenericStack<Integer> s2 = new GenericStack<>();
        s2.push2(1);
        s2.push2(2);

        ////////////////////////////////// List ///////////////////////////////////
        System.out.println(s2.pop2());
        System.out.println(s2.pop2());

    }
}