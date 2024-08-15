package tree.battleGroundTree;

import tree.TreeNode;

public class findValinSeaarch700 {

    public TreeNode findVal(TreeNode root, Integer val){
        if (root==null||root.value==val){return root;}
        if (root.value>val){return findVal(root.left,val);}
        else {return findVal(root.right,val);}

    }

}
