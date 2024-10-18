import java.util.regex.Pattern;
import java.util.regex.MatchResult;

/*
Lab Exercise #5.3 Print the names between asterisks
 */
public class PrintAllNames {
    public static void main(String[] args) {
        printNames("instructor name = *Andrew* and name = *Erick*");
        // separation line to distinguish different outputs
        System.out.println("=".repeat(20));
        printNames("instructor name = *John* and name =*Doe*");

        System.out.println("=".repeat(20));
        printNames("MAKIMA and Ginger Pork");
    }

    public static void printNames(String str) {
        // define the patterns for the target string
        String targetStringPrefix = "name = *";
        String targetStringSuffix = "*";

//        // as alternatives, use regular expression to extract the names
//        Pattern.compile(Pattern.quote(targetStringPrefix) + "(.*?)" + Pattern.quote(targetStringSuffix))
//                .matcher(str)
//                .results()
//                .forEach(m -> System.out.println(m.group(1)));

        // extract names within asterisks and stores them in an array
        int i = 0;
        while (i < str.length()) {
            int start = str.indexOf(targetStringPrefix, i);
            if (start == -1) {
                // if no prefix is found, break the loop
                break;
            }
            String strAfterStart = str.substring(start + targetStringPrefix.length());
            int end = strAfterStart.indexOf(targetStringSuffix);
            if (end == -1) {
                // if no suffix is found, break the loop
                break;
            }
            String name = strAfterStart.substring(0, end);
            System.out.println(name);

            // update the index to search for the next name
            i = start + targetStringPrefix.length() + end + targetStringSuffix.length();
        }
    }
}
