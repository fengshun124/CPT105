/*
Lab Exercise #5.2 Count the occurrences of a question mark in a string
 */
public class CountQuestionMark {
    public static void main(String[] args) {
        System.out.println(countQuestionMark("?????"));
        System.out.println(countQuestionMark("Hello, how are you?"));
        System.out.println(countQuestionMark("CPT105"));
        System.out.println(countQuestionMark(""));
    }

    public static int countQuestionMark(String str) {
        // count the number of question marks in the string
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }
}
