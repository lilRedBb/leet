package DP;

public class rob198 {

/**输入：[1,2,3,1]
 输出：4
 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 偷窃到的最高金额 = 1 + 3 = 4 。
 在不访问相邻两个房间的基础上，怎么做能让收入最多**/

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;  // No houses to rob
        int n = nums.length;
        if (n == 1) return nums[0];  // Only one house to rob

        int[] dp = new int[n];
        dp[0] = nums[0];  // Max money after robbing the first house
        dp[1] = Math.max(nums[0], nums[1]);  // Max money after robbing the first two houses

        for (int i = 2; i < n; i++) {
            // Decide whether to rob the current house or not
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];  // Maximum money that can be robbed
    }
}
