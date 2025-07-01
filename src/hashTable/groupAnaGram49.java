package hashTable;

import java.util.*;

public class groupAnaGram49 {
    /**Example 1:  这个方法的时间复杂的是 n* klogk， k是list中最长的元素的长度

     Input: strs = ["eat","tea","tan","ate","nat","bat"]
     Output: [["bat"],["nat","tan"],["ate","eat","tea"]]**/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (!anagramMap.containsKey(sorted)) {
                anagramMap.put(sorted, new ArrayList<>());
            }
            anagramMap.get(sorted).add(s);
        }

        return new ArrayList<>(anagramMap.values());
    }

    //这个方法的时间复杂度几乎是n，因为没有排序，而是通过每个str的单词出现的次数，制造出一个int list
    //把这个list作为key
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i).append('#'); //用符号隔开，是怕出现1,11  和11，1 被搞混的现象
            }
            String key = sb.toString();

            // ✅ Manual check and insert
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
