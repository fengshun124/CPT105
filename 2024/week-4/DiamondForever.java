/*
Lab #4.2 A Diamond is FORever - Nested For Loops
Print a diamond pattern using asterisks (*) or dots (.) with spaces in between, based on the given number of rows.
 */


import java.util.Scanner;

public class DiamondForever {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = keyboard.nextInt();

        if (rows < 1) {
            System.out.println("Please enter a positive number.");
        } else {
            diamond(rows);
        }
    }

    public static void diamond(int numOfRow) {
        // determine the middle row
        int mid = (numOfRow + 1) / 2;

        // loop for each row in the diamond
        for (int i = 0; i < numOfRow; i++) {
            int numStars = i < mid ? 2 * i + 1 : 2 * (numOfRow - i - 1) + 1;
            int numDots = (numOfRow - numStars) / 2;

            for (int j = 0; j < numDots; j++) {
                System.out.print(". ");
            }
            // print stars
            for (int j = 0; j < numStars; j++) {
                System.out.print("* ");
            }
            // print dots again
            for (int j = 0; j < numDots; j++) {
                System.out.print(". ");
            }
            System.out.println();
        }
    }
}
