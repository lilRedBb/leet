package Array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt13 {
    public int romanToInt(String s) {
        // Define a map for Roman numeral values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            // If the next character exists and has a higher value, it's a subtractive combination
            if (i < n - 1 && romanValues.get(currentChar) < romanValues.get(s.charAt(i + 1))) {
                result -= romanValues.get(currentChar);
            } else {
                result += romanValues.get(currentChar);
            }
        }

        return result;
    }
}
