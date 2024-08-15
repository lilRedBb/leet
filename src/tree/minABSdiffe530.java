package tree;

public class minABSdiffe530 {

    //返回一棵树上，两个相连node之间的差，这里面的最小的abs
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.value - prev);
        }
        prev = node.value;

        inOrderTraversal(node.right);
    }
}
