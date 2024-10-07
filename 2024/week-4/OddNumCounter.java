/*
Exercise #4.1 - Odd Number Count
The function is implemented in the countOddNum method.
 */

public class OddNumCounter {
    public static void main(String[] args) {
        // input target array
        int[] srcList = ImportData.importArray();
        // show results
        System.out.println("the number of odd numbers: " + countOddNum(srcList));
    }

    public static int countOddNum(int[] list) {
        int oddNum = 0;
        for (int j : list) {
            if (j % 2 != 0) {
                oddNum++;
            }
        }
        return oddNum;
    }

}
