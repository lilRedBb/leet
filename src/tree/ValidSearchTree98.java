package tree;

public class ValidSearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if ((low != null && node.value <= low) || (high != null && node.value >= high)) {
            return false;
        }

        return isValid(node.left, low, node.value) && isValid(node.right, node.value, high);
    }
}
