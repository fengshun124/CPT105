/*
Lab #4.2 A Diamond is FORever - Nested For Loops
Print a diamond pattern using asterisks (*) or dots (.) with spaces in between, based on the given number of rows.
In this snippet, two methods are implemented to print the diamond pattern (thought it only requires one method).
 */


import java.util.Scanner;

public class DiamondForever {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = keyboard.nextInt();

        if (rows < 1 || rows % 2 == 0) {
            System.out.println("Please enter a positive odd number.");
        } else {
            diamond(rows);
        }
    }

    public static void diamond(int numOfRow) {
        // determine the middle row
        int mid = numOfRow / 2;

        // print the upper and lower half of the diamond separately
        for (int row = 0; row < numOfRow; row++) {
            // print the upper half of the diamond
            if (row <= mid) {
                for (int col = 0; col < numOfRow; col++) {
                    if (col >= mid - row && col <= mid + row) {
                        System.out.print("* ");
                    } else {
                        System.out.print(". ");
                    }
                }
            } else {
                // print the lower half of the diamond
                for (int col = 0; col < numOfRow; col++) {
                    if (col >= row - mid && col < numOfRow - (row - mid)) {
                        System.out.print("* ");
                    } else {
                        System.out.print(". ");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("\n" + "=-".repeat(numOfRow) + "\n");

        // more efficient way to print the diamond
        // iterate through the rows
        for (int row = -mid; row <= mid; row++) {
            // iterate through the columns
            for (int col = -mid; col <= mid; col++) {
                // check the Manhattan distance from the center
                if (Math.abs(row) + Math.abs(col) <= mid) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}