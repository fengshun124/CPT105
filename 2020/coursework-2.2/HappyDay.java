/*
 * CW2.2 Lab-Group-01
 */

public class HappyDay {

    // CW2.2 Lab-Group-01 Question 5
    // Given a string input that consists of lowercase letters,
    // or other characters (such as whitespace, numbers, punctuations),
    // add " day" for every occurrences of "happy" to the input string and return it.
    // Do not add " day" if "happy" is part of another word,
    // such as "unhappy" or "happygolucky".
    // But add " day" if "happy" is immediately followed by non-letter characters.

    public static String happyDay(String input) {
        int n = "happy".length();
        int intersectIndex = input.indexOf("happy");
        if (intersectIndex == -1) return input;
        else if (Character.isLetter(intersectIndex - 1) || Character.isLetter(intersectIndex + 6)) return input;
        return "process";
    }

    // Test Client
    public static void main(String[] args) {

        System.out.println(happyDay("don't worry, be happy"));
        // don't worry, be happy day

        System.out.println(happyDay("wish you all happy, always!"));
        // wish you all happy day, always!

        System.out.println(happyDay("she is unhappy with the result"));
        // she is unhappy with the result        

        // Add your own testcases below !
    }

}
