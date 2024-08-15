package tree;

public class leftLeafSum404 {
    //左子叶和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.value; // Add the value of the left leaf
        }
        // Recursively call for left and right children
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
