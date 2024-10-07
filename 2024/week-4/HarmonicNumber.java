/*
Lecture Example 1
 */

import java.util.Scanner;

public class HarmonicNumber {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println(sum);
    }
}
