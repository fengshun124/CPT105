/*
Lab #10: Java Calculator that evaluates mathematical expressions
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression:");

        // evaluate input expression
        String inputEquation = scanner.nextLine();
        while (!inputEquation.equalsIgnoreCase("exit")) {
            try {
                double result = evaluateExpression(inputEquation);
                System.out.println(" = " + result);
            } catch (Exception e) {
                System.out.println("Failed to evaluate the expression: " + e.getMessage());
            }
            System.out.println("Enter a mathematical expression (type 'exit' to quit):");
            inputEquation = scanner.nextLine();
        }
    }

    // evaluates a mathematical expression
    private static double evaluateExpression(String expression) {
        List<String> postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    // converts infix expression to postfix using the Shunting Yard algorithm
    private static List<String> infixToPostfix(String expression) {
        Stack<Character> operatorStack = new Stack<>();
        List<String> output = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
            } else {
                if (!numberBuffer.isEmpty()) {
                    output.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }

                if (c == ' ') continue;

                if (isOperator(c)) {
                    if (c == '!') {
                        output.add("!");
                    } else {
                        // Handle other operators
                        while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                            output.add(String.valueOf(operatorStack.pop()));
                        }
                        operatorStack.push(c);
                    }
                } else if (c == '(') {
                    operatorStack.push(c);
                } else if (c == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        output.add(String.valueOf(operatorStack.pop()));
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                        operatorStack.pop();
                    } else {
                        throw new IllegalArgumentException("Mismatched parentheses");
                    }
                }
            }
        }

        if (!numberBuffer.isEmpty()) {
            output.add(numberBuffer.toString());
        }

        while (!operatorStack.isEmpty()) {
            char top = operatorStack.pop();
            if (top == '(') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(String.valueOf(top));
        }

        return output;
    }

    // evaluates a postfix expression
    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                if (token.charAt(0) == '!') {
                    double a = stack.pop();
                    stack.push(calcFactorial(a));
                } else {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(calcBinaryOperation(a, b, token.charAt(0)));
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }

    // calculates the result of a binary operation
    private static double calcBinaryOperation(double a, double b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '%' -> a % b;
            case '^' -> Math.pow(a, b);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    // calculates factorial for unary operator '!'
    private static double calcFactorial(double n) {
        if (n < 0 || n != Math.floor(n)) {
            throw new IllegalArgumentException("Factorial is only defined for non-negative integers");
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // returns the precedence of an operator
    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/', '%' -> 2;
            case '^' -> 3;
            case '!' -> 4;
            default -> -1;
        };
    }

    // checks if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == '!';
    }

    // checks if a string is numeric
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
