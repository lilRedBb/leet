package tree.battleGroundTree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class levelOrder {
    public List<List<TreeNode>> theMain(TreeNode root){
        if (root==null){return null;}
        List<List<TreeNode>> treeList = new ArrayList<>();
        helper(root,treeList,0);
        return treeList;

    }

    private void helper(TreeNode root, List<List<TreeNode>> treeList, int level){
        if (level >= treeList.size()){treeList.add(new ArrayList<>());}

        treeList.get(level).add(root);

        if (root.left!=null){helper(root.left,treeList,level+1);}
        if (root.right!=null){helper(root.right,treeList,level+1);}
    }
}
