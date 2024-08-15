package hashTable;

public class ransomNote383 {
    //string a = "aab"
    //String b = "aba"
    //判断a能不能由b里的元素组成，一个元素用一次


    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count each letter in the magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if the ransom note can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }

        return true;
    }


    /**Character to Array Index Mapping:

     c - 'a' converts a character c to its corresponding index in the alphabet.
     For example, if c is 'a', c - 'a' equals 0. If c is 'b', c - 'a' equals 1, and so on.
     This works because in the ASCII character set, the characters 'a' to 'z' are contiguous and start from 97 (the ASCII value for 'a').
     Increment Frequency Count:

     count[c - 'a']++ increments the value at the index corresponding to the character c in the count array.
     This effectively counts how many times each character appears in the magazine string.**/
}
