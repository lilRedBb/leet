package tree.battleGroundTree;

import tree.TreeNode;

public class maxDEPTH {

    public int md(TreeNode root){
        if (root==null){return 0;}
        int leftD = md(root.left);
        int rightD = md(root.right);
        return Math.max(leftD,rightD)+1;
    }
}
