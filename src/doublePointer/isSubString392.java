package doublePointer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class isSubString392 {
    // ace 也是 ajdcjej的子序列，但是aec就不是
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int sIndex = 0, tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }


}
