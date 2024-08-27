/*
    Exercise 2.1 What day is it?
 */

import java.util.Scanner;

public class DateToDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Sy = input.nextLine();
        String Sm = input.nextLine();
        String Sd = input.nextLine();
        int y = Integer.parseInt(Sy);
        int m = Integer.parseInt(Sm);
        int d = Integer.parseInt(Sd);

        input.close();

        int a = y - (14 - m) / 12;
        int b = a + (a / 4) - (a / 100) + (a / 400);
        int c = m + 12 * ((14 - m) / 12) - 2;
        int day = (d + b + (31 * c) / 12) % 7;
        System.out.println("It's day " + day + " !\n");
    }
}


/*
    Exercise 2.2 Polar Coordinates
 */
import java.util.Scanner;

public class PolarCoordinates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        double r = Math.hypot(x, y);
        double theta = Math.atan2(y, x);

        System.out.println("r = " + r + "\n" + "theta = " + theta);
    }
}


/*
    Coursework 2.1 CMYK to RGB
 */
import java.util.Scanner;

public class CMYKtoRGB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double C = Double.parseDouble(scanner.nextLine());
        double M = Double.parseDouble(scanner.nextLine());
        double Y = Double.parseDouble(scanner.nextLine());
        double K = Double.parseDouble(scanner.nextLine());

        double r = 255 * (1 - K) * (1 - C);
        double g = 255 * (1 - K) * (1 - M);
        double b = 255 * (1 - K) * (1 - Y);

        System.out.println("red = " + Math.round(r) + "\n" + "green = " + Math.round(g) + "\n" + "blue = " + Math.round(b) + "\n");
    }
}
//Below is author's solution
import java.util.Scanner;

public class CMYKtoRGB_ANS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double cyan = Double.parseDouble(input);
        input = scanner.nextLine();
        double magenta = Double.parseDouble(input);
        input = scanner.nextLine();
        double yellow = Double.parseDouble(input);
        input = scanner.nextLine();
        double black = Double.parseDouble(input);

        double white = 1 - black;
        int red = (int) Math.round(255 * white * (1 - cyan));
        int green = (int) Math.round(255 * white * (1 - magenta));
        int blue = (int) Math.round(255 * white * (1 - yellow));

        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
}


/*
    Coursework 2.2 Great Circle Distance
 */
import java.util.Scanner;

public class GreatCircleDistance {
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);

        double earthRadius = 6371.0;
        double srcLatitude = Math.toRadians(Double.parseDouble(consoleInput.nextLine()));
        double srcLongitude = Math.toRadians(Double.parseDouble(consoleInput.nextLine()));
        double dstLatitude = Math.toRadians(Double.parseDouble(consoleInput.nextLine()));
        double dstLongitude = Math.toRadians(Double.parseDouble(consoleInput.nextLine()));

        double distance = 2 * earthRadius * Math.asin(Math.sqrt(Math.pow(Math.sin((dstLatitude - srcLatitude) / 2), 2)
                + Math.cos(srcLatitude) * Math.cos(dstLatitude) * Math.pow(Math.sin((dstLongitude - srcLongitude) / 2), 2)));

        System.out.println(distance + " kilometres");
    }
}
//below is author's solution
import java.util.Scanner;

public class GreatCircleDistanceANS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Math.toRadians(Double.parseDouble(scanner.nextLine()));
        double y1 = Math.toRadians(Double.parseDouble(scanner.nextLine()));
        double x2 = Math.toRadians(Double.parseDouble(scanner.nextLine()));
        double y2 = Math.toRadians(Double.parseDouble(scanner.nextLine()));

        double r = 6371.0;
        double dist;
        dist = 2 * r * Math.asin(Math.sqrt(Math.pow(Math.sin((x2 - x1) / 2), 2) +
                Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2), 2)));
        System.out.println(dist + " kilometres");
    }
}