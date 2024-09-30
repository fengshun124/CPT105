/*
Exercise #3.1 Comparison of Integer Sums
 */

import java.util.Scanner;

public class CompareIntSum {
    public static void main(String[] args) {
        // import the three numbers
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        // compare the three numbers
        int result = compare(n, m, k);
        System.out.println(result);
    }

    public static int compare(int n, int m, int k) {
//        if (n + m == k) {
//            return -1;
//        } else return Math.max(n + m, k);

//        using ternary operator to abbreviate the code
        return (n + m == k) ? -1 : (Math.max(n + m, k));
    }
}
