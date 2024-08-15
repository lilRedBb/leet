package tree;

public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
