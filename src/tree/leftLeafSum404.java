package tree;

import java.util.LinkedList;
import java.util.Queue;

public class leftLeafSum404 {
    //左子叶和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.value; // Add the value of the left leaf
        }
        // Recursively call for left and right children
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    public int theSumNotRecursive(TreeNode root){
        if (root==null||(root.left==null&&root.right==null))return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if (curr.left!=null&&curr.left.left==null&&curr.left.right==null){
                sum+=curr.left.value;
            }

            if (curr.left!=null){
                queue.offer(curr.left);
            }

            if (curr.right!=null){
                queue.offer(curr.right);
            }
        }
        return sum;
    }
}
