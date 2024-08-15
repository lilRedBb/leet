package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
    //在列表里找三个元素，元素门的下标不能重复，他们的和要等于0，找出所有的组合，放入一个list of list中返回

    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // Sort the array
            Arrays.sort(nums);

            // Iterate through the array
            for (int i = 0; i < nums.length - 2; i++) {
                // Avoid duplicates for the first element
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Use two pointers to find the remaining two elements
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Avoid duplicates for the second element
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Avoid duplicates for the third element
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++; // Move the left pointer to the right to increase the sum
                    } else {
                        right--; // Move the right pointer to the left to decrease the sum
                    }
                }
            }

            return result;
        }
    }

}
