package _01_Einführung.Übung_01b;

import java.util.Scanner;

public class Main {
    private static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long startTime = System.currentTimeMillis();
        System.out.println(fib(n));
        System.out.println(startTime);
        memory = new long[n + 1];

        memory[0] = 0;
        memory[1] = 1;

        long endTime = System.currentTimeMillis();
        System.out.println(fibMemo(n));
        System.out.println(endTime - startTime);
    }

    private static long fibMemo(int n) {
        if(memory[n] != 0) {
            return memory[n];
        }
        memory[n] = fibMemo(n - 1) + fib(n - 2);
        return memory[n];
    }
    private static long fib(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }
}
