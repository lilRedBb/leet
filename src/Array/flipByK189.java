package Array;

public class flipByK189 {
    //数组向右边移动k个位置，【1234】k=2, 3412
    public void rotate(int[] nums, int k) {
        k %= nums.length; //保证k在length的范围内
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums, int left, int right){
        while (left<right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
