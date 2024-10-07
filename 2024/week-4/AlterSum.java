/*
Coursework 1 #4.2 Alternating Sum and Difference of Elements
The function is implemented in the alterSum method.
 */

public class AlterSum {
    public static void main(String[] args) {
        // input target array
        int[] srcList = ImportData.importArray();
        // show results
        System.out.println("the sum of elements at even indices minus the sum of elements at odd indices: " +
                alterSum(srcList));
    }

    public static int alterSum(int[] list) {
        int alternatingSum = 0;
        for (int i = 0; i < list.length; i++) {
            if (i % 2 == 0) {
                alternatingSum -= list[i];
            } else {
                alternatingSum += list[i];
            }
        }
        return alternatingSum;
    }
}
