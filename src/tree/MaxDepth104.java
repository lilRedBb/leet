package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, the depth is 0
        }


        // The maximum depth of the current node is 1 (for the current node)
        // plus the maximum of the depths of the left and right subtrees
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthNonrecurSive(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            depth++;  // Increase depth after each level
        }

        return depth;
    }

}
