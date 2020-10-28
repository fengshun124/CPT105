/*
    Exercise 3.1 Black Jack
 */

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());


        if (x > 21) {
            if (y > 21) {
                System.out.println("-1\n");
            } else {
                System.out.println(y);
            }
        } else {
            if (y > 21) {
                System.out.println(x);
            } else if (Math.abs(x - 21) > Math.abs(y - 21) && x <= 21) {
                System.out.println(y + "\n");
            } else {
                System.out.println(x + "\n");
            }
        }
    }
}


/*
    Exercise 3.2 Pandemic Spread
 */
import java.util.Scanner;

public class PandemicSpread {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int infected = Integer.parseInt(scanner.nextLine());
        int numInfect = Integer.parseInt(scanner.nextLine());
        int population = Integer.parseInt(scanner.nextLine());

        int day = 1;

        for (; infected < population; day++) {
            if (infected < population) {
                infected = infected + infected * numInfect;
            }
        }
        System.out.println(day);


    }
}


/*
    Coursework 3.1 Right Triangle
 */
import java.util.Scanner;

public class RightTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());

        if (x > 0 && y > 0 && z > 0) {
            if (x * x == y * y + z * z || y * y == z * z + x * x || z * z == x * x + y * y) {
                System.out.println("true\n");
            } else {
                System.out.println("false\n");
            }
        } else {
            System.out.println("false\n");
        }
    }
}
//Author's Solution
import java.util.Scanner;

public class RightTriangleANS {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int a = Integer.parseInt(kb.nextLine());
        int b = Integer.parseInt(kb.nextLine());
        int c = Integer.parseInt(kb.nextLine());
        boolean answer;

        if (a <= 0 || b <= 0 || c <= 0) {
            answer = false;
        } else if (a * a + b * b == c * c || c * c + b * b == a * a || a * a + c * c == b * b) {
            answer = true;
        } else {
            answer = false;
        }
        System.out.println(answer);
    }
}


/*
    Coursework 3.2 Hailstone Sequence
 */
import java.util.Scanner;

public class HailStone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int count = 1;
        for (; n > 1; count++) {
            // odd
            if ((n & 1) != 0) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
        }
        System.out.println(count + "\n");
    }
}
//Author's Solution
import java.util.Scanner;

public class HailStoneANS {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = Integer.parseInt(kb.nextLine());

        int length = 1;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }
        System.out.println(length);
    }
}