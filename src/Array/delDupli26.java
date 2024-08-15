package Array;

public class delDupli26 {
    /**给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，
     * 使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。**/
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){return 0;}
        int i = 0;
        for (int j=1;j< nums.length;j++){
            if (nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
