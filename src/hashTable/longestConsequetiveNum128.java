package hashTable;

import java.util.HashSet;
import java.util.Set;

public class longestConsequetiveNum128 {
    /**Input: nums = [100,4,200,1,3,2]
     Output: 4
     Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.**/
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only start counting when `num` is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
