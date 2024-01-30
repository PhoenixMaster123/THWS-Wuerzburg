public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.einfuegen("Cool");
        list.einfuegen("Zylla");
        list.einfuegen("Aaronson");
        String result = list.toString();
        System.out.println(result);
    }
}