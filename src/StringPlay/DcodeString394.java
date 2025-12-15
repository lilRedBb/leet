package StringPlay;
import java.util.*;

// 3[a2[b]] abbabbabb
//2a2b   aabb

public class DcodeString394 {

    public static String decodeString(String s) {
        // Stack to store multipliers (how many times to repeat)
        Stack<Integer> multiplierStack = new Stack<>();

        // Stack to store the string built BEFORE entering a bracket pair
        Stack<StringBuilder> stringBeforeBracketStack = new Stack<>();

        // The string we're currently building at this level
        StringBuilder currentString = new StringBuilder();

        // Accumulator for multi-digit numbers (e.g., "12" in "12[abc]")
        int currentMultiplier = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build multi-digit number: "12[abc]" → accumulate 1, then 12
                currentMultiplier = currentMultiplier * 10 + (ch - '0');

            } else if (ch == '[') {
                // We're entering a new nested level
                // Save current context (multiplier and string so far) to stacks
                multiplierStack.push(currentMultiplier);
                stringBeforeBracketStack.push(currentString);

                // Start fresh for the new bracketed section
                currentString = new StringBuilder();
                currentMultiplier = 0;

            } else if (ch == ']') {
                // We're exiting a bracket - time to multiply and combine

                // Get how many times to repeat the string we just built
                int timesToRepeat = multiplierStack.pop();

                // Get the string that existed before this bracket pair
                StringBuilder stringBeforeBracket = stringBeforeBracketStack.pop();

                // Repeat current string and append to what came before
                String stringToRepeat = currentString.toString();
                for (int i = 0; i < timesToRepeat; i++) {
                    stringBeforeBracket.append(stringToRepeat);
                }

                // The combined result becomes our new current string
                currentString = stringBeforeBracket;

            } else {
                // Regular letter - just add to current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        // Test cases with step-by-step explanation
        System.out.println("Input: '3[a2[c]]'");
        System.out.println("Process: 3[a2[c]] → 3[acc] → accaccacc");
        System.out.println("Output: " + decodeString("3[a2[c]]")); // "accaccacc"

        System.out.println("\nInput: '3[a]2[bc]'");
        System.out.println("Process: 3[a] → aaa, then 2[bc] → bcbc → aaabcbc");
        System.out.println("Output: " + decodeString("3[a]2[bc]")); // "aaabcbc"

        System.out.println("\nInput: '2[abc]3[cd]ef'");
        System.out.println("Output: " + decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
    }
}