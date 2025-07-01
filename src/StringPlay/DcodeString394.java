package StringPlay;
import java.util.*;

//input s = "3[a]2[bc]"
//output "aaabcbc"
// in    3[a2[c]]
//accaccacc

public class DcodeString394 {



    public static String decodeString(String s) {
        Stack<Integer> repeatCountStack = new Stack<>();
        Stack<StringBuilder> previousStringStack = new Stack<>();
        StringBuilder substringToRepeat = new StringBuilder();
        int repeatCount = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Convert multi-digit number (e.g., "12[abc]" should extract 12)
                repeatCount = repeatCount * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current repeat count & previous string onto stacks
                repeatCountStack.push(repeatCount);
                previousStringStack.push(substringToRepeat);

                // Reset for the new substring inside brackets
                substringToRepeat = new StringBuilder();
                repeatCount = 0;
            } else if (ch == ']') {
                // Get stored repeat count and previous string
                //
                int times = repeatCountStack.pop();
                StringBuilder previousString = previousStringStack.pop();

                // Append the repeated substring to the previous string
                for (int i = 0; i < times; i++) {
                    previousString.append(substringToRepeat);
                }

                // Update substringToRepeat with new built string
                substringToRepeat = previousString;
            } else {
                // Append normal characters to the current substring being built
                substringToRepeat.append(ch);
            }
        }

        return substringToRepeat.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        System.out.println(decodeString(input)); // Output: "accaccacc"
    }

}
