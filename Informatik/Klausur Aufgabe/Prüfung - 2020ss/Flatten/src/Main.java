public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6},
                {7, 8},
                {9, 10, 11, 12}
        };

        int[] result = flatten(arr);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] flatten(int[][] arr)
    {
        int gesamtLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                gesamtLength++;
            }
        }

        int[] result = new int[gesamtLength];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[count++] = arr[i][j];
            }
        }

        return result;
    }
}
