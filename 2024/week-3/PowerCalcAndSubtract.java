/*
Exercise #3.2 Power Calculation and Subtraction
 */

import java.util.Scanner;

public class PowerCalcAndSubtract {
    public static void main(String[] args) {
        // import the three numbers
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // compare the three numbers
        int result = calcPowerAndSubtraction(n, m);
        System.out.println(result);
    }

    public static int calcPowerAndSubtraction(int n, int m) {
        // validate n and m (n < m, m ＞ 3, n != 1)
        if (n >= m || m <= 3 || n == 1) {
            System.exit(1);
        }

        // return n ** k - m when the power k of n is greater than
        int k = 0;
        while (Math.pow(n, k) - m < 0) {
            k++;
        }
        return (int) (Math.pow(n, k) - m);
    }
}
