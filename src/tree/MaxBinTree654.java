package tree;

public class MaxBinTree654 {
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
}
