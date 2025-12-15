package tree;

import java.util.Stack;

public class ValidSearchTree98 {
    //时间负责度是On 他会把所有的节点都走一遍，如果没遇到false的话
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if ((low != null && node.value <= low) || (high != null && node.value >= high)) {
            return false;
        }

        return isValid(node.left, low, node.value) && isValid(node.right, node.value, high);
    }

    public boolean isValidBSTNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer prev = null;

        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the node
            current = stack.pop();
            if (prev != null && current.value <= prev) {
                return false;
            }
            prev = current.value;

            // Move to the right subtree1
            current = current.right;
        }

        return true;
    }
}
