package tree.battleGroundTree;

import com.sun.source.tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class scratch1 {
    public boolean pathSum(TreeNode root, Integer target){
        if (root==null){return true;}
        if (root.left==null && root.right==null){
            return root.value==target;
        }
        int remain = target-root.value;
        return pathSum(root.left,remain)||pathSum(root.right,remain);
    }

    public boolean validSearchTree(TreeNode root){
        return isValidBTS(root, null, null);
    }

    private boolean isValidBTS(TreeNode root, Integer low,  Integer high){
        if (root==null){return true;}
        if (low!=null && root.value<=low||high!=null && root.value>=high){
            return false;
        }
        return  isValidBTS(root.left,low,root.value)||isValidBTS(root.right,root.value,high);
    }

    public int minDepthh(TreeNode root){
        if (root==null){
            return 0;
        }
        if (root.left==null){
            return  minDepthh(root.right)+1;
        }
        if (root.right==null){
            return minDepthh(root.left)+1;
        }
        return Math.min(minDepthh(root.right),minDepthh(root.left))+1;
    }


    private int minDiff = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinDiff (TreeNode root){
        inorderABS(root);
        return minDiff;
    }
    private void inorderABS(TreeNode root){
        if (root==null)return;
        inorderABS(root.left);
        if (prev!=null){
            minDiff = Math.min(minDiff,root.value-prev);
        }
        prev = root.value;
        inorderABS(root.right);
    }

    public TreeNode mergeTreeRecur(TreeNode t1, TreeNode t2){
        if (t1==null)return t2;
        if (t2==null)return t1;
        TreeNode newTree = new TreeNode(t1.value+t2.value);
        newTree.left = mergeTreeRecur(t1.left,t2.left);
        newTree.right = mergeTreeRecur(t1.right,t2.right);
        return newTree;

    }

    public TreeNode mergeTree(TreeNode t1, TreeNode t2){
        if (t1==null)return t2;
        if (t2==null)return t1;
        Stack<TreeNode[]> stack= new Stack<>();
        stack.push(new TreeNode[]{t1,t2});
        while (!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            t[0].value += t[1].value;
            if (t[0].left==null)
                {t[0].left=t[1].left;}
            else
                {stack.push(new TreeNode[] {t[0].left, t[1].left});}

            if (t[0].right==null)
                {t[0].right=t[1].right;}
            else
                {stack.push(new TreeNode[]{t[0].right,t[1].right});}



        return t1;


        }
    }
}
