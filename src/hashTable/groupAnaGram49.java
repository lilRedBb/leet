package hashTable;

import java.util.*;

public class groupAnaGram49 {
    /**Example 1:

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
}
