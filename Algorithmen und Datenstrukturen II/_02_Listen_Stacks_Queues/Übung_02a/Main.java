package _02_Listen_Stacks_Queues.Übung_02a;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        smartArray.add(2);
        smartArray.add(6);
        smartArray.add(3);
        smartArray.add(1);
        smartArray.add(7);
        smartArray.add(9);

        System.out.println(smartArray.get(4));
        System.out.println(smartArray.getLast());
        System.out.println(smartArray.search(1));

    }
}
