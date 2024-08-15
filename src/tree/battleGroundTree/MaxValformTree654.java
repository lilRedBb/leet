package tree.battleGroundTree;

import tree.TreeNode;

public class MaxValformTree654 {
    public TreeNode formMaxTr(int[] nums){

        return helper(nums,0,nums.length);
    }

    private TreeNode helper(int[] nums, int left, int right){
        if (left==right){return null;}
        int maxIndex = findMax(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, left, maxIndex-1);
        root.right = helper(nums, maxIndex+1,right);
        return root;

    }

    private int findMax(int[] nums, int left, int right){
        int  tempIndex = left; //这里已经把第一个比较的元素设置为left，所以下面的i直接是left+1，而不是left
        for (int i=left+1;i<right;i++){
            if (nums[i]>nums[tempIndex]){
                tempIndex =i;
            }
        }
        return tempIndex;
    }
}
