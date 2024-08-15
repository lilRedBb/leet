package tree;

public class BinsearchTreeSearch700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.value == val) {
            return root;
        }
        if (root.value > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
