package tree.battleGroundTree;


import tree.TreeNode;

public class symity {
    public boolean siSimi(TreeNode root){
        if (root.left==null){return true;}
        return isMi(root.left, root.right);
    }

    public boolean isMi(TreeNode left,TreeNode right){
        if (left==null&&right==null){return true;}
        if (left==null||right==null){return false;}
        return left.value==right.value&&isMi(left.right,right.left)&&isMi(left.left,right.right);
    }
}
