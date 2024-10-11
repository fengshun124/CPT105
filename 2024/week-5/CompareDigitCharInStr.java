/*
Coursework 1 #5.2: Compare Digit Counts in Two Strings
 */
public class CompareDigitCharInStr {
    public static void main(String[] args) {
        // input two strings
        String s1 = ImportData.importString();
        String s2 = ImportData.importString();
        // compare the digits in the two strings
        System.out.println(compareDigitCharInStr(s1, s2));
    }

    public static boolean compareDigitCharInStr(String s1, String s2) {
        int s1DigitCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (Character.isDigit(s1.charAt(i))) {
                s1DigitCount++;
            }
        }
        int s2DigitCount = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (Character.isDigit(s2.charAt(i))) {
                s2DigitCount++;
            }
        }
        return s1DigitCount > s2DigitCount;
    }
}
