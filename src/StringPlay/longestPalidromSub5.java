package StringPlay;

public class longestPalidromSub5 {
//    Example 1:
//
//    Input: s = "babad"
//    Output: "bab"
//    Explanation: "aba" is also a valid answer.
//            Example 2:
//
//    Input: s = "cbbd"
//    Output: "bb"
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;  // boundaries of the best palindrome

        for (int i = 0; i < s.length(); i++) {
            // expand around one center (odd-length)
            int len1 = expand(s, i, i);
            // expand around two centers (even-length)
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // length of palindrome -1 是因为loop end时，left和right已经outside palidrom 1 step
    }
}
