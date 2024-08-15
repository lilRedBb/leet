package tree.battleGroundTree;

import tree.TreeNode;

public class Valid98 {

    public boolean panduan(TreeNode root){

        return valid(root,null,null);
    }
    public boolean valid(TreeNode root, Integer low, Integer high){
        if (root==null){return true;}
        if ((root!=null&&root.value<low)||(root!=null&&root.value>high)){return false;}
        return valid(root.left,low,root.value)&&valid(root.right,root.value,high);
    }


}
