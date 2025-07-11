package _06_Evolutionary_Algorithmen;

import java.util.Arrays;

public class Hill_Climbing_Algorithm_2 {
    private static final int START_VALUE = 2;
    private static final int TARGET_VALUE = 3;
    private static final int OBSTACLE = 1;

    // Bewegungsrichtungen: oben, unten, links, rechts
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 3},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {2, 0, 0, 0, 0}
        };

        int[] arr = findStartEndPointPosition(matrix);

        int currentRow = arr[0];
        int currentCol = arr[1];
        int targetRow = arr[2];
        int targetCol = arr[3];

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        System.out.println("Startpunkt: (" + currentRow + ", " + currentCol + ")");
        System.out.println("Zielpunkt: (" + targetRow + ", " + targetCol + ")");
        System.out.println("Pfad:");

        while (currentRow != targetRow || currentCol != targetCol) {
            visited[currentRow][currentCol] = true;

            int[] nextMove = null;
            double shortestDistance = Double.MAX_VALUE;

            // Nachbarn überprüfen
            for (int[] direction : DIRECTIONS) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (isValidMove(matrix, newRow, newCol, visited)) {
                    double distance = calculateEuclideanDistance(newRow, newCol, targetRow, targetCol);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        nextMove = new int[]{newRow, newCol};
                    }
                }
            }

            if (nextMove == null) {
                System.out.println("Kein Pfad gefunden!");
                return;
            }

            currentRow = nextMove[0];
            currentCol = nextMove[1];
            System.out.println("(" + currentRow + ", " + currentCol + ")");
        }

        System.out.println("Ziel erreicht!");
    }

    private static boolean isValidMove(int[][] matrix, int row, int col, boolean[][] visited) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && matrix[row][col] != OBSTACLE && !visited[row][col];
    }

    private static double calculateEuclideanDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private static int[] findStartEndPointPosition(int[][] matrix) {
        int startPointRow = -1;
        int startPointCol = -1;

        int endPointRow = -1;
        int endPointCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == START_VALUE) {
                    startPointRow = row;
                    startPointCol = col;
                }
                if (matrix[row][col] == TARGET_VALUE) {
                    endPointRow = row;
                    endPointCol = col;
                }
            }
        }
        return new int[]{startPointRow, startPointCol, endPointRow, endPointCol};
    }
}
