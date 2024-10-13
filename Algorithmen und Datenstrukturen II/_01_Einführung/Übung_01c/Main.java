package _01_Einführung.Übung_01c;

public class Main {
    public static void main(String[] args) {
        /*
                         5
                        3 7
                       6 1 2
                      3 8 5 4
                     3 4 2 6 0
        */

        // Create example pyramide
        int[][] pyramid = new int[][] {

                {5},
                {3,7},
                {6,1,2},
                {3,8,5,4},
                {3,4,2,6,0}
        };
        System.out.println(findLongestPath(pyramid));
    }

    /*
    Bottom-Up Approach:
      Instead of starting from the top and trying all possible paths (which would be inefficient),
      we use a bottom-up approach. This means we start from the second-to-last row of the
      pyramid and work our way upwards.
     */
    public static int findLongestPath(int[][] pyramid) {

        for (int row = pyramid.length - 2; row >= 0; row--) {
            for (int col = 0; col < pyramid[row].length; col++) {
                if(pyramid[row + 1][col] > pyramid[row + 1] [col + 1]) { // 6 > 1 -> 6
                    pyramid[row][col] += pyramid[row + 1][col];
                }
                else {
                    pyramid[row][col] += pyramid[row + 1][col + 1];
                }
            }
        }
        return pyramid[0][0];
    }
    // Note: I start from the second layer from the pyramid to have more paths,
    // and after that I check every path and which number is larger
    /*
                         5
                        3 7 → we start from here
                       6 1 2
                      3 8 5 4
                     3 4 2 6 0 // → the longest path is: 5 3 6 8 4
        */
}
