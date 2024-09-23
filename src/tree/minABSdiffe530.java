package tree;

public class minABSdiffe530 {
    //算法是用在bfs上的，所以不需要用abs()方法就能确保得到一个正数

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
    /**Processing node 1:

     At this point, it does not go to node 2 yet. Instead, it processes node 1.
     Since prev is null, it skips the comparison and sets prev = 1.
     After processing node 1, the function calls inOrderTraversal(node.right). Since node.right of 1 is null, this call returns immediately.

     Backtracking to node 2:**/
}
