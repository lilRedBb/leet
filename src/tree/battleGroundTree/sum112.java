package tree.battleGroundTree;

import tree.TreeNode;

public class sum112 {
    public boolean isThereAsume(TreeNode root, int sum){
        if (root==null){return false;}
        if (root.left==null&&root.right==null){return root.value==sum;}
        int remaining = sum - root.value;
        return isThereAsume(root.left,remaining)||isThereAsume(root.right,remaining);
    }
}
