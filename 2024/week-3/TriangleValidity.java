/*
Coursework 1 #3.1 Triangle Validation
 */

import java.util.Scanner;

public class TriangleValidity {
    public static void main(String[] args){
        // import the three numbers
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // validate if the three numbers can form a triangle
        boolean result = isTriangle(a, b, c);

        if (result) {
            System.out.println("Correct");
        } else {
            System.out.println("Not Correct");
        }
    }
    public static boolean isTriangle(int a, int b, int c){
        return a + b > c && a + c > b && b + c > a;
    }
}
