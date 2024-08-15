package tree.battleGroundTree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class leveloderd2 {
    public void printInorder(TreeNode root){
        if (root==null){
            System.out.println("empty");}
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.println(current.value);
            if (current.left!=null){queue.offer(current.left);}
            if (current.right!=null){queue.offer(current.right);}

        }

    }
}
