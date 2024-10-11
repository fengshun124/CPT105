/*
Exercise 5.1: Counting Space in a String
 */

public class CountSpaceInString {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("enter a string: ");
        String str = scanner.nextLine();
        System.out.println("the number of spaces in the string: " + countSpace(str));
    }

    public static int countSpace(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}
