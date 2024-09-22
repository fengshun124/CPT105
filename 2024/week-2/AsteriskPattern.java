/*
Coursework 1 #2.2 & Exercise #4.3 Print a triangle pattern of asterisks
CVW1 #2.2 is the simplified version of Exercise #4.3,
thus (almost) the same code is used for both.
 */

public class AsteriskPattern {
    public static void main(String[] args) {
        // fix n = 3 would satisfy CW1 # 2.2
        printAsteriskPattern(3);
    }

    public static void printAsteriskPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
