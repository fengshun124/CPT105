/*
Lab #5.1 Repeat String
 */
public class RepeatString {
    public static void main(String[] args) {
        System.out.println(repeatString("Hello", 3));
        System.out.println(repeatString("World", 5));
        System.out.println(repeatString("Java", 0));
        System.out.println(repeatString("Programming", 1));
        System.out.println(repeatString("", 2));
    }

    public static String repeatString(String str, int times) {
        // directly return the repeated string
        // return str.repeat(Math.max(0, times));

        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < times; i++) {
            resultStr.append(str);
        }
        return resultStr.toString();
    }
}
