package DP;

import java.util.Arrays;

public class longestAcend300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Initialize all values to 1, as the minimum length of LIS is 1

        int maxLength = 1;  // The result for the longest increasing subsequence

        // Loop through each element
        for (int i = 1; i < n; i++) {
            // Compare with all previous elements
            for (int j = 0; j < i; j++) {
                // If the current element is larger than a previous one,
                // update dp[i] to be the maximum of its current value or dp[j] + 1
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Keep track of the maximum length found
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
