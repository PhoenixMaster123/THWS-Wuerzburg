package Klausurvorberaitung.ss2024.Aufgabe1_Schachbrett;

import java.util.Iterator;

public class Schachbrett implements Iterable<Character>{
    private final char[][] brett;

    public Schachbrett(char[][] brett) {
        this.brett = brett;
    }

    @Override
    public Iterator<Character> iterator() {
        return new BrettIterator();
    }
    private class BrettIterator implements Iterator<Character> {

        private int rowIndex = 0;
        private int colIndex = 0;

        @Override
        public boolean hasNext() {
            return rowIndex < brett.length;
        }

        @Override
        public Character next() {
            char element = brett[rowIndex][colIndex];
            if(colIndex < brett[rowIndex].length - 1) {
               colIndex++;
            } else {
                rowIndex++;
                colIndex = 0;
            }
            return element;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < brett.length; row++) {
            for (int col = 0; col < brett[row].length; col++) {
                sb.append(brett[row][col]);
            }
        }
        return sb.toString();
    }
}
