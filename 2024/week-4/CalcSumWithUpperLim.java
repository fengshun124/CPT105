/*
Coursework 1 #4.1 Calculate Sum Until Max Number
 */

public class CalcSumWithUpperLim {
    public static void main(String[] args) {
        // input target array
        int[] srcList = ImportData.importArray();
        // input upper limit
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("enter the upper limit: ");
        int upperLim = scanner.nextInt();
        // show results
        System.out.println("the sum of elements less than the upper limit: " +
                sumElementsSumLessThanLim(srcList, upperLim));
    }

    public static int sumElementsSumLessThanLim(int[] list, int maxNum) {
        int sum = 0;
        for (int j : list) {
            if (sum >= maxNum) {
                break;
            }
            sum += j;
        }
        return sum;
    }
}
