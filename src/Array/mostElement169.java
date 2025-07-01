package Array;

import java.util.HashMap;
import java.util.Map;

public class mostElement169 {
    //moore counting
    //这里计算的不是出现次数最多的，而是出现频率大于1/2的，所以这样做是对的，不然还是要计算max
    public int majorityElement(int[] nums) {
        int count=0;
        Integer candidate = null;
        for (int num:nums){
            if (count==0){
                candidate = num;

            }
            count += (candidate==num)?1:-1;
        }
        return candidate;
    }
    //moore voting只能用于保证有大于1/2的频率的众数出现的时候才要用，如果不能保证频率，但是要找到最大频率的数，就用map
    public int mostFrequentElement(int[] nums) {
        // Optional check for empty array
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int majority = nums[0];

        for (int num : nums) {
            // Increment count for the current num
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Update mode if this count is now bigger
            int currentCount = countMap.get(num);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                majority = num;
            }
        }

        return majority;
    }

}
