package tree;

import java.util.Stack;

public class MaxBinTree654 {
    //取出数组中最大的数作为root,然后root.left是root在数组中往左的sub array组成的， root。right是右边
    //如果root在array中，左边已经没其他数字了，root.left就是null, 再看看root的右边还有没有数字，继续组成右树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }

        // Find the index of the maximum element in the current range
        int maxIndex = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);

        // Recursively build the left and right subtrees
        root.left = build(nums, left, maxIndex);
        root.right = build(nums, maxIndex + 1, right);

        return root;
    }

    private int maxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //下面的方法最好，时间复杂度是N，上面是n方

    public TreeNode constructMaximumBinaryTreeOpt(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for (int num : nums) {
            TreeNode current = new TreeNode(num);
            // Pop until the current number is less than or equal to the stack top
            while (!stack.isEmpty() && stack.peek().value < num) {
                current.left = stack.pop();
            }
            // If stack is not empty, then the current node is less than the stack top.
            // Set current as the right child of the stack top.
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }
            // Push current node onto the stack.
            stack.push(current);
        }

        // The bottom of the stack is the root of the maximum binary tree.
        // When only one element remains in the stack, it is the root.
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
