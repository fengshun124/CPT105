/*
Exercise 5.2: Counting Numeric Characters in a String
 */

public class CompareNumInString {
    public static void main(String[] args) {
        String str = ImportData.importString();
        System.out.println("is the number of numbers more than the number of characters: " +
                isNumMoreThanChar(str));
    }

    public static int isNumMoreThanChar(String str) {
        int countNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                countNum++;
            }
        }
        int countChar = str.length() - countNum;
        return Integer.compare(countNum, countChar);
    }
}
