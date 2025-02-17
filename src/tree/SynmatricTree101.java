package tree;

public class SynmatricTree101 {
        //这个方法的时间复杂度是n，最后的&&有abort的作用
    // &&的作用就是，在

        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true; // Both subtrees are empty
            if (left == null || right == null) return false; // Only one of the subtrees is empty

            return (left.value == right.value) // The values at the nodes are the same
                    && isMirror(left.right, right.left) // The right subtree of the left tree is a mirror of the left subtree of the right tree
                    && isMirror(left.left, right.right); // The left subtree of the left tree is a mirror of the right subtree of the right tree
        }

}
