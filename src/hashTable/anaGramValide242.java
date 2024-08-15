package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class anaGramValide242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }


//如果字符中有unicode就不能用老方法了，就要用map来技术，最后比较计数
    public boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            countMap.put(charS, countMap.getOrDefault(charS, 0) + 1);
            countMap.put(charT, countMap.getOrDefault(charT, 0) - 1);
        }

        for (int count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
