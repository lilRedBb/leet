package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//返回一棵树上的所有path到一个列表里
public class AllPathToleaf257 {
    //先直插树底，凑成最长的string，放入array，然后recursion往回走，每走出来一层，就减少一点Len
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            StringBuilder path = new StringBuilder();
            dfs(root, path, paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
        int len = path.length(); // Remember the current length for backtracking

        // If the StringBuilder already has content, append the arrow.
        if (path.length() != 0) {
            path.append("->");
        }
        path.append(node.value);


        // If it's a leaf node, add the current path to the list of paths.
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            // Continue the DFS on the left and right children.
            if (node.left != null) {
                dfs(node.left, path, paths);
            }
            if (node.right != null) {
                dfs(node.right, path, paths);
            }
        }
        // Backtrack: reset the StringBuilder to its previous state.
        path.setLength(len);
    }

    public List<String> binaryTreePathsNonRe(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        // Stack to store pairs of (node, path_so_far)
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, String.valueOf(root.value)));

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            String path = current.path;

            // If it's a leaf node, add the path to result
            if (node.left == null && node.right == null) {
                result.add(path);
                continue;
            }

            // Add children to stack with updated paths
            if (node.right != null) {
                stack.push(new Pair(node.right, path + "->" + node.right.value));
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, path + "->" + node.left.value));
            }
        }

        return result;
    }

    // Helper class to store node and its path
    class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
}
