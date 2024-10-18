/*
Lab Exercise #5.4 Check if a string is a palindrome
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("anna"));
    }

    public static boolean isPalindrome(String str) {
        // check if the string is a palindrome
        for (int idx = 0; idx < str.length() / 2; idx++) {
            if (str.charAt(idx) != str.charAt(str.length() - idx - 1)) {
                return false;
            }
        }
        return true;
    }
}
