/*
Coursework 1 #5.1 Find the First Occurrence of a Character in a String
 */

public class FindFirstOccurrence {
    public static void main(String[] args) {
        // input target string
        String str = ImportData.importString();
        // input target char
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("enter the char to be searched: ");
        char targetChar = scanner.next().charAt(0);
        // show results
        System.out.println("the target char \"" + targetChar + "\" is at index: " + findFirstOccurrence(str, targetChar));
    }

    public static int findFirstOccurrence(String str, char targetChar) {
        // validate the input str and targetChar
        if ((str == null) || str.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                return i;
            }
        }
        return -1;
    }
}
