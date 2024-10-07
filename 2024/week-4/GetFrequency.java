/*
Lecture Example 2
 */

public class GetFrequency {
    public static void main(String[] args) {
        System.out.println(getFrequency(new int[] {1, 2, 1}, 1));
        System.out.println(getFrequency(new int[] {1, 2, 1}, 2));
    }

    public static int getFrequency(int[] input, int num) {
        int count = 0;
        for (int j : input) {
            if (j == num) {
                count++;
            }
        }
        return count;
    }
}
