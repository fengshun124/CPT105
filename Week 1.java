/*
    Exercise 1.1 "I love you 3000."
 */
public class LoveThreeThousands {
    public static void main(String[] args) {
        int threeThousands = 3000;
        System.out.println("\"I love you " + threeThousands + ".\"");
    }
}


/*
    Coursework 1.1 Simple Math
    Below is author's solution
*/

public class SimpleMath {
    public static void main(String[] args) {
        int num1 = 10, num2 = 3;
        double real1 = 10.0, real2 = 3.0;

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 / num2 = " + (num1 / num2));
        System.out.println("real1 + real2 = " + (real1 + real2));
        System.out.println("real1 / real2 = " + (real1 / real2));
    }
}


/*
    Coursework 1.2 ASCII Art
*/
public class CharXmasTree {
    public static void main(String[] args) {
        String xmasTree = "   *\n  / \\\n /   \\\n/     \\\n--| |--\n-------\n";
        System.out.println(xmasTree);
    }
}
// Below is author's solution
public class CharXmasTreeAns {
    public static void main(String[] args) {
        System.out.println("   *  ");
        System.out.println("  / \\  ");
        System.out.println(" /   \\  ");
        System.out.println("/     \\  ");
        System.out.println("--| |--");
        System.out.println("-------");
    }
}