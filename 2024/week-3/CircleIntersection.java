/*
Coursework 1 #3.2 Check Intersection of Two Circles
 */

import java.util.Scanner;

public class CircleIntersection {
    public static void main(String[] args) {
        // import circles and radii
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int r1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int r2 = scanner.nextInt();

        // check if intersect
        isIntersect(x1, y1, r1, x2, y2, r2);
    }

    public static void isIntersect(
            int x1, int y1, int r1, int x2, int y2, int r2) {
        boolean result = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < r1 + r2;

        if (result) {
            System.out.println("Intersect");
        } else {
            System.out.println("Not Intersect");
        }
    }
}
