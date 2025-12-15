package tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public int minDepthNonRecursive(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // If it's a leaf node, return current depth
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            depth++;
        }

        return depth; // Technically unreachable
    }

}
