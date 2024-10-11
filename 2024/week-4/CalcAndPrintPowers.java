/*
Lab #4.1 Print the square and cube of numbers from 0 to 10.
Notice that the following implementation additionally takes the input from the user,
and check if the input is a positive number.
 */


import java.util.Scanner;

class CalcAndPrintPowers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = keyboard.nextInt();

        // error handling for negative number
        if (num < 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        // show the power and cubic of current number with formatted printing
        for (int i = 0; i <= num; i++) {
            System.out.println("Num. " + i + " Square " + i * i + " Cube " + i * i * i);
            // or use Math.pow() method to calculate the power and cubic
            // System.out.println("Num. " + i + " Square " + Math.pow(i, 2) + " Cube " + Math.pow(i, 3));
            // print separation lines for better readability
            System.out.println("-------------------------------------------------");
        }
    }
}