package tree;

import java.util.LinkedList;
import java.util.Queue;

public class completeBinTreeNodesCount222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root;
        TreeNode right = root;

        // Calculate the depth of the leftmost and rightmost paths
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }

        // If the leftDepth equals rightDepth, the tree is perfect
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; // 2^depth - 1
        }

        // If not, recursively count the nodes in left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }



    //cengxu bianli
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                count++; // Increment count for each node encountered
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return count;
    }
}
