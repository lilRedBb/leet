package tree.battleGroundTree;

import tree.TreeNode;

public class scratchInvert {
    public TreeNode invert(TreeNode root){
        if (root==null){return null;}
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;

    }
}
