package tree;


public class TreeIsBalanced110 {
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

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true; // A null tree is balanced

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if current node is balanced and recursively check left and right subtrees
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced2(root.left)
                && isBalanced2(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0; // Base case: height of null is 0

        // Height of a node is 1 + maximum of left height and right height
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
