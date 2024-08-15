package Array;

public class GasAndcost134 {
    //出发的时候油箱里有油gas【那么多油】
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            sum += diff;

            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
//        int start = solution.canCompleteCircuit(gas, cost);
//        System.out.println("Starting gas station index: " + start); // Output: 3
//    }
}
