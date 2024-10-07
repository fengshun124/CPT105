/*
Exercise #4.4 Fibonacci Sequence Generation
The core function is implemented in generateFibonacciSeq method.
 */

import java.util.Arrays;

public class FibonacciSeq {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("enter the size of the Fibonacci sequence: ");
        int n = scanner.nextInt();
        System.out.println("The Fibonacci sequence is: " +
                Arrays.toString(generateFibonacciSeq(n)));
    }

    public static int[] generateFibonacciSeq(int n) {
        if (n == 0) {
            System.exit(1);
        }
        int[] fibSeq = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                fibSeq[i] = i;
            } else {
                fibSeq[i] = fibSeq[i - 1] + fibSeq[i - 2];
            }
        }
        return fibSeq;
    }
}
