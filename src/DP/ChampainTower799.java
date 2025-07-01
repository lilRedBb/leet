package DP;

public class ChampainTower799 {

    public double champagneTowerSol(int poured, int query_row, int query_glass) {
        // dp[r][c] represents the amount of champagne in glass (r, c)
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;

        for (int r = 0; r < query_row; r++) {
            for (int c = 0; c <= r; c++) {
                // Only overflow if the current glass has more than 1 unit.
                double overflow = (dp[r][c] - 1.0) / 2.0;
                if (overflow > 0) {
                    dp[r+1][c] += overflow;
                    dp[r+1][c+1] += overflow;
                }
            }
        }
        // The answer is the minimum between 1 and the champagne in the target glass.
        return Math.min(1.0, dp[query_row][query_glass]);
    }


    public static void main(String[] args) {
        ChampainTower799 solution = new ChampainTower799();

        System.out.println(solution.champagneTowerSol(1, 0, 0)); // Expected: 1.0
        System.out.println(solution.champagneTowerSol(1, 1, 0)); // Expected: 0.0
        System.out.println(solution.champagneTowerSol(2, 1, 0)); // Expected: 0.5
        System.out.println(solution.champagneTowerSol(4, 2, 1)); // Expected: 1.0
        System.out.println(solution.champagneTowerSol(10, 3, 1)); // Expected: Between 0.0 and 1.0
        System.out.println(solution.champagneTowerSol(1000000000, 99, 49)); // Expected: 1.0
    }

}
