package Array;
//game2
public class JumpGame45 {
    //童55，但是要找到最少的跳跃次数
    //所以在for的第一个farthest那里，在跳出第一步后，farthest会在坐标0-跳到位置之间的元素的最大值产生，重复下去，
    // 就一直在每次跳跃后的中间所有节点选出跳跃的最大距离
    public int jump(int[] nums) {
        int jumps = 0; // Number of jumps needed to reach the end
        int currentEnd = 0; // The farthest point that can be reached with the current number of jumps
        int farthest = 0; // The farthest point that can be reached with one more jump

        // Iterate over each index except the last one
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current range
            if (i == currentEnd) {
                jumps++; // Increment the jump count
                currentEnd = farthest; // Update the end of the range to the farthest point
            }

            // If we can already reach the last index
            if (currentEnd >= nums.length - 1) {
                break;
            }
        }

        return jumps;
    }
}
