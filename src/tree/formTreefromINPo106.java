package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class formTreefromINPo106 {
    //从中，后序的数组里得出一个树
    //后序是把root最后放进去的，所以后序的最后一个元素是root
    //in [9,3,15,20,7]
    //post[9,15,7,20,3]
    //我们现在可以知道po里的3是根，那么在in里，3分隔了左树和右数，那么左就是9，右就是15,20,7
    //pos里的9的右边就是右树的，15,7,20 ； 20在最后，那么它就是佑树的root
    //再用20放到in里看，20左边是15，那么15应该就在20的左边
    private int postIndex;
    private int[] postorder;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.postIndex = postorder.length - 1;

        // Build a hashmap to store value -> its index relations
        int idx = 0;
        for (int val : inorder) {
            inorderIndexMap.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int inLeft, int inRight) {
        // if there is no elements to construct subtrees
        if (inLeft > inRight) {
            return null;
        }

        // pick up postIndex element as a root
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        // root splits inorder list into left and right subtrees
        int index = inorderIndexMap.get(rootVal);

        // recursion
        postIndex--;
        // build right subtree
        root.right = helper(index + 1, inRight);
        // build left subtree
        root.left = helper(inLeft, index - 1);

        return root;
    }

    public TreeNode buildTreeWhile(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);

        int inorderIndex = inorder.length - 1;

        // Traverse postorder from right to left (excluding the root which we already processed)
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode curr = new TreeNode(postorder[i]);
            TreeNode parent = null;

            // Find the correct parent for current node
            while (!stack.isEmpty() && stack.peek().value == inorder[inorderIndex]) {
                parent = stack.pop();
                inorderIndex--;
            }

            if (parent != null) {
                // Current node is the left child
                parent.left = curr;
            } else {
                // Current node is the right child
                stack.peek().right = curr;
            }

            stack.push(curr);
        }

        return root;
    }


}
