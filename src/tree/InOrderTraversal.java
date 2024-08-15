package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    //左边先展示
    void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        // Traverse the tree
        while (currentNode != null || !stack.isEmpty()) {

            /* Reach the left most Node of the current Node */
            while (currentNode != null) {
                /* place pointer to a tree node on the stack before traversing the node's left subtree */
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            /* Current must be NULL at this point */
            currentNode = stack.pop();

            System.out.print(currentNode.value + " ");

            /* we have visited the node and its left subtree. Now, it's right subtree's turn */
            currentNode = currentNode.right;
        }
    }


    void inorderRecurse(TreeNode root){
        List<TreeNode> nodeList = new ArrayList<>();
        helper(root, nodeList);
    }

    private void helper(TreeNode node, List<TreeNode> nodeList){
        if (node==null){return;}
        helper(node.left, nodeList);
        nodeList.add(node);
        helper(node.right,nodeList);
    }
}
