/*
Lab #4.3 Rolling Dice
roll a die with a given number of sides n times and calculate the statistics of the rolls.
 */

import java.util.Random;
import java.util.Scanner;

public class RollingDice {
    // rollDice() with the given number of rolls and dice sides
    public static int[] rollDice(int rollsCount, int diceSides) {
        int[] rolls = new int[rollsCount];
        for (int i = 0; i < rollsCount; i++) {
            rolls[i] = (int) (Math.random() * diceSides) + 1;
            System.out.println("Roll " + (i + 1) + ": " + rolls[i]);
        }
        return rolls;
    }

    // rollDice() with 12 sides and 6 rolls, exactly as required in the lab instructions
    public static int[] rollDice() {
        Random rand = new Random();
        int[] rolls = new int[6];

        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = rand.nextInt(12) + 1;
            System.out.println("Roll " + (i + 1) + ": " + rolls[i]);
        }
        return rolls;
    }

    // calculate and display the highest value rolled and its last occurrence
    public static void calcHighest(int[] rolls) {
        int maxValue = rolls[0];
        int maxPos = 0;

        // iterate through the rolls to find the highest value
        for (int i = 1; i < rolls.length; i++) {
            // update the highest value and its position
            if (rolls[i] > maxValue) {
                maxValue = rolls[i];
                maxPos = i;
            }
        }
        // display the highest value and its position
        System.out.println("The highest value rolled is " + maxValue + " at roll " + (maxPos + 1));
    }

    // calculate and display the lowest value rolled and its last occurrence, similar to calcHighest()
    public static void calcLowest(int[] rolls) {
        int minValue = rolls[0];
        int minPos = 0;

        for (int i = 1; i < rolls.length; i++) {
            if (rolls[i] < minValue) {
                minValue = rolls[i];
                minPos = i;
            }
        }
        System.out.println("The lowest value rolled is " + minValue + " at roll " + (minPos + 1));
    }

    // calculate and display the average value of the rolls
    public static void calcAverage(int[] rolls) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        double average = (double) sum / rolls.length;
        System.out.println("The average value rolled is " + average);
    }

    // match a row with any of the previous rolls
    public static void diceMatch(int[] rolls) {
        boolean match = false;
        int matchAttempts = 0;

        while (!match) {
            int roll = (int) (Math.random() * 12) + 1;
            matchAttempts++;
            System.out.println("Match attempt " + matchAttempts + " with roll value " + roll);

            // check if the current roll matches any of the previous rolls
            for (int i = 0; i < rolls.length; i++) {
                if (roll == rolls[i]) {
                    match = true;
                    System.out.println("Match found with value " + roll + " at roll " + (i + 1));
                    break;
                }
            }

            // display a message if no match is found
            if (!match) {
                System.out.println("No match with " + roll);
            }
            // break the loop if no match is found after 100 attempts
            if (matchAttempts > 100) {
                System.out.println("No match found after 100 attempts.");
                break;
            }
        }
    }

    public static void diceMarch(int[] rolls, int diceSides) {
        boolean match = false;
        int matchAttempts = 0;

        while (!match) {
            int roll = (int) (Math.random() * diceSides) + 1;
            matchAttempts++;
            System.out.println("Match attempt " + matchAttempts + " with roll value " + roll);

            // check if the current roll matches any of the previous rolls
            for (int i = 0; i < rolls.length; i++) {
                if (roll == rolls[i]) {
                    match = true;
                    System.out.println("Match found with value " + roll + " at roll " + (i + 1));
                    break;
                }
            }

            // display a message if no match is found
            if (!match) {
                System.out.println("No match with " + roll);
            }
            // break the loop if no match is found after 100 attempts
            if (matchAttempts > 100) {
                System.out.println("No match found after 100 attempts.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        // roll the dice with 12 sides and 6 rolls
        int[] rolls = rollDice();
        // calculate and display the highest value rolled and its last occurrence
        calcHighest(rolls);
        // calculate and display the lowest value rolled and its last occurrence
        calcLowest(rolls);
        // calculate and display the average value of the rolls
        calcAverage(rolls);
        // match a row with any of the previous rolls
        diceMatch(rolls);

        System.out.println("\n" + "=-=-".repeat(10) + "\n");

        // advanced: roll the dice with a given number of sides and rolls
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of sides: ");
        int diceSides = keyboard.nextInt();
        System.out.println("Enter the number of rolls: ");
        int rollsCount = keyboard.nextInt();
        int[] customRolls = rollDice(rollsCount, diceSides);
        // statistics for the custom rolls
        calcHighest(customRolls);
        calcLowest(customRolls);
        calcAverage(customRolls);
        diceMarch(customRolls, diceSides);
    }
}
