package tree;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertIntoBST(root.left, value);
        } else {
            root.right = insertIntoBST(root.right, value);
        }

        return root;
    }
}
