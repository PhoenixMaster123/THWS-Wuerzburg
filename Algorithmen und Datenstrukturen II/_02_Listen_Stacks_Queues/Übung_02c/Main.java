package _02_Listen_Stacks_Queues.Übung_02c;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        smartArray.loadFile("C:\\Users\\krisi\\OneDrive\\Desktop\\Informatik\\Semester 3\\Algorithmen und Datenstrukturen II\\Algorithmen und Datenstrukturen II\\src\\_02_Listen_Stacks_Queues\\Übung_02b\\EURUSD_H1.csv");

        Candle candle = new Candle("2013-08-22 01:00:00",1.33372,1.33415,1.33333,1.33394,5719);
        System.out.println("The founded candle is on position: " + smartArray.search(candle));
        smartArray.checkDragonflyDojiPattern();
    }
}
