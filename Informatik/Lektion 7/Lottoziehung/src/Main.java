import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ////////////////////////////////// Variant with Hashset //////////////////////////
       /* Scanner scanner = new Scanner(System.in);
        HashSet<Integer> lottoZahlen = HashSet.newHashSet(6);

        for (int i = 0; i <= 6; i++) {
            int lotto = (int) (Math.random() * 49) + 1;
            lottoZahlen.add(lotto);
        }
        System.out.println(lottoZahlen);
        */
    //}
        Scanner scanner = new Scanner(System.in);
        int[] lottoZahlen = new int[6];
        for (int i = 0; i < lottoZahlen.length; i++)
        {
            int lotto = (int) (Math.random() * 49) + 1;
            lottoZahlen[i] = lotto;
        }
        int[] sortedMassiv = BubbleSort(lottoZahlen);
        for (int i: sortedMassiv)
        {
         System.out.print(i + " ");
        }

    }
    private static int[] BubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if the elements are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}