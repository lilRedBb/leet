package tree;

public class MinDepth111 {

    //找到最短的 叶子节点， 所以如果左边，或者右边为null时候，要继续从另一边往下走，知道叶子，所以比max多了两个if
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, the depth is 0
        }

        // If left subtree is null, recur for right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If right subtree is null, recur for left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both subtrees are not null, get the minimum of the depths of the two subtrees
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
