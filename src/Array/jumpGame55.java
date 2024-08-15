package Array;

//非负数的array,从下边为0的元素开始，元素的值代表你能从这里往下跳的最大的步数，如果值为0就是不能跳了
//判断你能否调到最后
public class jumpGame55 {
    public boolean canJump(int[] nums) {
        int reach = 0; // The furthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false; // If we can't reach this index, return false
            reach = Math.max(reach, i + nums[i]); // Update the furthest index we can reach
        }
        return true; // If we can reach the last index, return true
    }
}
