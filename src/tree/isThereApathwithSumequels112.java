package tree;


//有有没有一个整体仙露上的值的和等于给定的值
public class isThereApathwithSumequels112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // If we reached a leaf node, check if the current sum equals the target sum
        if (root.left == null && root.right == null) {
            return root.value == targetSum;
        }
        // Recursively check the left and right subtrees with the adjusted target sum
        int remainingSum = targetSum - root.value;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }



}
