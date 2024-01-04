public class Main {
    public static void main(String[] args) {

        Post p1 = new Post("Alice", "Bob", "Gutes neues Jahr! ");
        Post p2 = new Post("Bob","Alice" , "Danke! Guten Rutsch ins neue Jahr!");
        Post p3 = new Post("Alice","Bob" , "Frohe Weihnachten!");

        Timeline timeline = new Timeline();
        timeline.fuegePostEin(p1);
        timeline.fuegePostEin(p2);
        timeline.fuegePostEin(p3);
        timeline.gibAus();
    }
}