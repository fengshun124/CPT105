/*
The following ImportArray class is used to import an array from the user.
It does NOT correspond to any of the exercises or coursework.
 */
public class ImportData {
    public static void main(String[] args) {
    }

    public static String importString() {
        // input target string
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("enter a string: ");
        return scanner.nextLine();
    }

    public static int[] importArray() {
        // input target array
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // initialise the array
        System.out.print("enter the size of the array: ");
        int n = scanner.nextInt();
        int[] list = new int[n];
        // input the elements of the array one by one
        System.out.println("enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        return list;
    }
}
