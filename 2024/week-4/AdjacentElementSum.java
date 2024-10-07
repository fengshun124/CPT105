/*
Exercise #4.2 - Sum of Adjacent Elements
The function is implemented in the sumAdjacentElements method.
 */

import java.util.Arrays;

public class AdjacentElementSum {
    public static void main(String[] args) {
        // input target array
        int[] srcList = ImportData.importArray();
        // show results
        System.out.println("the sum of adjacent elements: " +
                Arrays.toString(sumAdjacentElements(srcList)));
    }

    public static int[] sumAdjacentElements(int[] list) {
        if (list.length % 2 != 0) {
            System.exit(1);
        }
        int[] dstList = new int[list.length / 2];
        // assign the elements with rule dstList[i] = srcList[2i] + srcList[2i+1]
        for (int i = 0; i < dstList.length; i++) {
            dstList[i] = list[2 * i] + list[2 * i + 1];
        }
        return dstList;
    }
}
