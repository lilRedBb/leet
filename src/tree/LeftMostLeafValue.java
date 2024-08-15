package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostLeafValue {
    //最左边的最下面的叶子的值,使用的是bfs所以是一层一层的放，最后一层的时候，最左边的叶子最后出来
    //poll let out the first element
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;

        while (!queue.isEmpty()) {
            current = queue.poll();
            // Push right child first so that leftmost node will remain last at each level
            if (current.right != null) {
                queue.offer(current.right);
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
        }

        return current.value;
    }



    private int maxDepth = -1;
    private int bottomLeftValue = 0;

    public int findBottomLeftValueR(TreeNode root) {
        findBottomLeftValuer(root, 0);
        return bottomLeftValue;
    }

    private void findBottomLeftValuer(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // If this is the first node of this level
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.value;
        }

        // Recurse for left and right children, left first to ensure leftmost node is processed first at each level
        findBottomLeftValuer(node.left, depth + 1);
        findBottomLeftValuer(node.right, depth + 1);
    }
}
