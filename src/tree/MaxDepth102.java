package tree;

public class MaxDepth102 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, the depth is 0
        }

        // Recursively find the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The maximum depth of the current node is 1 (for the current node)
        // plus the maximum of the depths of the left and right subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }




    public class MaxDepth1112 {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0; // Base case: if the tree is empty, the depth is 0
            }

            // Recursively find the maximum depth of the left and right subtrees
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            // The maximum depth of the current node is 1 (for the current node)
            // plus the maximum of the depths of the left and right subtrees
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
