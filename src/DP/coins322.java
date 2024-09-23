package DP;

import java.util.Arrays;

public class coins322 {
    public int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // Fill the array with a large number (amount + 1)
        dp[0] = 0;  // Base case: 0 coins are needed to make amount 0

        // Loop through all amounts from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Check each coin denomination
            for (int coin : coins) {
                // If the coin can be used to make the current amount
                if (i - coin >= 0) {
                    // Update the dp array with the minimum number of coins needed
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the large number, return -1 to indicate that it's not possible to make the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
