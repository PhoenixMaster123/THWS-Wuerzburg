package IteratorMatrix;

import java.util.Iterator;

public class IteratorMatrix implements Iterable<String> {

    String[][] matrix;

    IteratorMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator<String> iterator() {
        return new StringMatrixIterator();
    }
    private class StringMatrixIterator implements Iterator<String> {

        private int rowIndex = 0;
        private int colIndex = 0;

        @Override
        public boolean hasNext() {
            return rowIndex < matrix.length;
        }

        @Override
        public String next() {
            String element = matrix[rowIndex][colIndex];

            if(colIndex < matrix[rowIndex].length - 1) {
                colIndex++;
            } else {
                rowIndex++;
                colIndex = 0;
            }

            return element;
        }
    }
}
