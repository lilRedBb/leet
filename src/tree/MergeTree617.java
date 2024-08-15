package tree;

import java.util.Stack;

public class MergeTree617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        TreeNode merged = new TreeNode(t1.value + t2.value);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);

        return merged;
    }


    //不地柜的方法就是直接把右边的树，接到左边
    //stack会存放一个list {TreeNodeleft,TreeNodeRight}
    public TreeNode notRecurmergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();



            // Add the values of t1 and t2 nodes
            t[0].value += t[1].value;

            // If the left child of t1 is null, assign it to the left child of t2
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }

            // If the right child of t1 is null, assign it to the right child of t2
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }

        return t1;
    }
}
