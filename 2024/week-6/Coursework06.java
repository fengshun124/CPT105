/*
Coursework 1 #6
 */

public class Coursework06 {
    private final String s1;
    private final String s2;

    // #6.1 initialise strings
    public Coursework06(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // #6.2 concatenate strings based on length
    @Override
    public String toString() {
        return s1.length() > s2.length() ? s1 + s2 : s2 + s1;
    }

    // #6.3 count digits characters in both strings
    public int countDigital() {
        // combined strings for counting
        String s = s1 + s2;
        // count of digits
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    // testing
    public static void main(String[] args) {
        Coursework06 example = new Coursework06("Hello123", "World456");
        System.out.println(example);
        System.out.println(example.countDigital());
    }
}
