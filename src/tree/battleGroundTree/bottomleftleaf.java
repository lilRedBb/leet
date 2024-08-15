package tree.battleGroundTree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class bottomleftleaf {

    public int btmLeft(TreeNode root){
        if (root==null){return -1;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;
        while (!queue.isEmpty()){
            current = queue.poll();
            if (current.right!=null){queue.offer(current.right);}
            if (current.left!=null){queue.offer(current.left);}

        }
        return current.value;
    }



    int maxDepth = -1;
    int maxVlaue = 0;
    public int btmleftM(TreeNode root){
        if (root==null){return -1;}
        return  maxVlaue;

    }

    private void helper(TreeNode root, int depth){
        if (root==null){return;}
        if (depth>maxDepth){
            maxVlaue = root.value;
            maxDepth = depth;

        }
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}
