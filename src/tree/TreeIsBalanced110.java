package tree;


public class TreeIsBalanced110 {
    //平衡水需要左边和右边的最深处的差，最多为1，最外层检查了root的left和right， 接着要继续recursive来检查里面的所有小left right树
    //方法1的时间复杂度只有n，要用这个，方法2不好，是n方
    //区别在于方法1有中断机制而且是直接插到最下面从最下面的node往上计算，
    // 方法二没有中断，而且是从上往下走的，所以每个node都要经历一次n的复杂度，所以不管怎么样他都会计算完。
    public boolean isBalanced1(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height if balanced
    }


}

public class TreeIsBalanced110 {
    private boolean balanced = true; // Track balance status

    public boolean isBalanced(TreeNode root) {
        balanced = true; // Reset for each call
        checkHeight(root);
        return balanced;
    }

    private int checkHeight(TreeNode node) {
        if (node == null || !balanced) { // Stop if already unbalanced
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
