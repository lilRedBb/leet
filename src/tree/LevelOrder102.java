package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, result, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;

        // If this is the first node of this level
        //下面的代码会一直做DFS，所以level在第一次DFS的，所以当第一次level=size的时候，就会给array加一层，那么array size就永远大于
        //这一层的其他node带过来的level了

        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.value);

        // Traverse the left child
        levelOrderHelper(node.left, result, level + 1);
        // Traverse the right child
        levelOrderHelper(node.right, result, level + 1);
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

}
