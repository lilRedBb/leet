package tree.battleGroundTree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class formTreeinorder106 {
    private int[] postorder;
    private int postIndex;
    private Map<Integer,Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postOrder){

        int tempIndex = 0;
        for (int value:inorder){
            inorderIndexMap.put(value, tempIndex++);
        }


        this.postorder = postOrder;
        this.postIndex = postorder.length-1;
        return helper(inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int left, int right){
        if (left>=right){return null;}
        int rootValue = postorder[postIndex];
        TreeNode root = new TreeNode(rootValue);

        int indexHelper = inorderIndexMap.get(rootValue);
        postIndex--;
        root.right = helper(inorder, indexHelper+1,right);
        root.left = helper(inorder, left,indexHelper-1);
        return root;
    }

}
