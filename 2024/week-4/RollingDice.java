/*
Lab #4.3 Rolling Dice
roll a die with a given number of sides n times and calculate the statistics of the rolls.
 */

import java.util.Scanner;

public class RollingDice {
    // roll the dice n times
    public static int[] rollDice(int n, int sides) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (int) (Math.random() * sides) + 1;
            System.out.println("Roll " + (i + 1) + ": " + result[i]);
        }
        return result;
    }

    // calculate the frequency of each side
    public static void calcHist(int[] rolls, int sides) {
        int[] freq = new int[sides];
        for (int roll : rolls) {
            freq[roll - 1]++;
        }
        for (int i = 0; i < freq.length; i++) {
            System.out.println("Frequency of side " + (i + 1) + ": " + freq[i]);
        }
    }

    // calculate the maximum roll and its position
    public static void calcMaxSides(int[] rolls) {
        int max = rolls[0];
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        System.out.print("Maximum roll: " + max + " at positions: ");
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == max) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    // calculate the minimum roll and its position
    public static void calcMinSides(int[] rolls) {
        int min = rolls[0];
        for (int roll : rolls) {
            if (roll < min) {
                min = roll;
            }
        }
        System.out.print("Minimum roll: " + min + " at positions: ");
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == min) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    // calculate the sides average
    public static void calcAverage(int[] rolls) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        double average = (double) sum / rolls.length;
        System.out.println("Average roll: " + average);
    }

    // show the statistics
    public static void rollStats(int[] rolls, int sides) {
        System.out.println("==== Rolling Statistics ====");
        calcHist(rolls, sides);
        calcMaxSides(rolls);
        calcMinSides(rolls);
        calcAverage(rolls);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of sides of the dice: ");
        int diceSides = keyboard.nextInt();
        System.out.print("Enter the number of rolls: ");
        int numRolls = keyboard.nextInt();

        if (diceSides < 2 || numRolls < 1) {
            System.out.println("Please enter a valid number of sides (>= 2) and rolls (> 0).");
            return;
        }

        // roll the dice!
        int[] rolls = rollDice(numRolls, diceSides);
        // show the statistics
        rollStats(rolls, diceSides);
    }
}
