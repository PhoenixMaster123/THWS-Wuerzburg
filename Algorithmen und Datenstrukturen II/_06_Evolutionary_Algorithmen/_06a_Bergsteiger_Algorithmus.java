package _06_Evolutionary_Algorithmen;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _06a_Bergsteiger_Algorithmus {
    private static final int[][] MATRIX = {
            {0, 1, 0, 0, 3},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {2, 0, 0, 0, 0}
    };

    private static final int START_VALUE = 2;
    private static final int TARGET_VALUE = 3;
    private static final int OBSTACLE = 1;

    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) {
        int[] start = findPoint(MATRIX, START_VALUE);
        int[] target = findPoint(MATRIX, TARGET_VALUE);

        if (start == null || target == null) {
            System.out.println("Startpunkt oder Zielpunkt nicht gefunden.");
            return;
        }

        List<int[]> path = findPath(start, target);
        if (path != null) {
            System.out.println("Pfad gefunden:");
            for (int[] point : path) {
                System.out.println(Arrays.toString(point));
            }
        } else {
            System.out.println("Kein Pfad gefunden.");
        }
    }

    private static List<int[]> findPath(int[] start, int[] target) {
        List<int[]> path = new ArrayList<>();
        boolean[][] visited = new boolean[MATRIX.length][MATRIX[0].length];
        path.add(start);
        visited[start[0]][start[1]] = true;

        int[] current = start;

        while (!Arrays.equals(current, target)) {
            int[] next = null;
            double shortestDistance = Double.MAX_VALUE;

            for (int[] direction : DIRECTIONS) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                if (isValidMove(newRow, newCol, visited)) {
                    double distance = calculateEuclideanDistance(newRow, newCol, target[0], target[1]);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        next = new int[]{newRow, newCol};
                    }
                }
            }

            if (next == null) {
                return null; // Kein weiterer Schritt möglich
            }

            path.add(next);
            visited[next[0]][next[1]] = true;
            current = next;
        }

        return path;
    }

    private static boolean isValidMove(int row, int col, boolean[][] visited) {
        return row >= 0 && row < MATRIX.length && col >= 0 && col < MATRIX[0].length
                && MATRIX[row][col] != OBSTACLE && !visited[row][col];
    }

    private static double calculateEuclideanDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private static int[] findPoint(int[][] matrix, int value) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == value) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }
}
