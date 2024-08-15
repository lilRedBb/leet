package tree.battleGroundTree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Scratch2 {

    public int NodesCount222(TreeNode root){

        if (root==null){return 0;}
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left!=null){
            leftDepth++;
            left = left.left;
        }
        while (right!=null){
            rightDepth++;
            right = right.right;
        }

        if (leftDepth == rightDepth){
            return (1<<leftDepth)-1;
        }else {
            return 1+NodesCount222(root.left)+NodesCount222(root.right);
        }

    }


    public int MEthodsCENGXU(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){return 0;}
        int count = 0;


        queue.offer(root);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i=0;i<queueSize;i++){
                TreeNode currentNode = queue.poll();
                count++;
                if (currentNode.left!=null){queue.offer(currentNode.left);}
                if (currentNode.right!=null){queue.offer(currentNode.right);}
            }
        }
        return count;
    }


}
