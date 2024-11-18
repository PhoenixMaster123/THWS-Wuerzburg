package Lektion19.genericStack;

public class Main {
    public static void main(String[] args) {
        Stack<String> s = new GenericStack<>();
        GenericStack<String> s2 = new GenericStack<>();
        s.push("Hallo");
        s.push("Welt");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}