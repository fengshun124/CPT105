/*
Lab #10: Java Calculator that evaluates given two numbers and an operator
 */

import java.util.Scanner;

public class SimpleCalculator {
    private final double num1;
    private final double num2;
    private final char operator;

    public SimpleCalculator(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the first number:");
        this.num1 = keyboard.nextDouble();

        System.out.println("Enter the second number:");
        this.num2 = keyboard.nextDouble();

        System.out.println("Enter the operator:");
        this.operator = keyboard.next().charAt(0);
        if (!isOperator()) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + calculate());
    }

    private boolean isOperator() {
        return switch (operator) {
            case '+', '-', '*', '/', '%', '^' -> true;
            default -> false;
        };
    }

    private double calculate() {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield num1 / num2;
            }
            case '%' -> {
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield num1 % num2;
            }
            case '^' -> Math.pow(num1, num2);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void main(String[] args) {
        while (true) {
            new SimpleCalculator(args);
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Another calculation? Press 'Y' to continue or any other key to exit.");
            String input = keyboard.nextLine();
            if (input.isEmpty()) {
                break;
            } else if (!input.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
}
