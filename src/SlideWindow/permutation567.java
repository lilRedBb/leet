package SlideWindow;

import java.util.Arrays;

public class permutation567 {
    public boolean tellPermu(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count frequencies for s1 and first window in s2
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (Arrays.equals(count1, count2)) return true;

            // Slide: remove the left char, add the next right char
            if (i + s1.length() < s2.length()) {
                count2[s2.charAt(i) - 'a']--;
                count2[s2.charAt(i + s1.length()) - 'a']++;
            }
        }

        return false;
    }
}
