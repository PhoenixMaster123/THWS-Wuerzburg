package IteratorMatrix;

public class Main {
    public static void main(String[] args) {
        String[][] matrix = {
                {"Eins", "Zwei", "Drei"},
                {"Vier", "Fünf", "Sechs"},
                {"Sieben", "Acht", "Neun", "Zehn"}
        };
        IteratorMatrix iteratorMatrix = new IteratorMatrix(matrix);

        for (String s : iteratorMatrix) {
            System.out.println(s);
        }
    }
}
