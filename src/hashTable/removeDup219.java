package hashTable;

import java.util.HashMap;
import java.util.Map;

public class removeDup219 {
    /**Given an integer array nums and an integer k,
     * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j]
     * and abs(i - j) <= k.



     Example 1:

     Input: nums = [1,2,3,1], k = 3
     Output: true**/

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numToIndexMap.containsKey(nums[i])) {
                int prevIndex = numToIndexMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            numToIndexMap.put(nums[i], i);
        }

        return false;
    }
}
