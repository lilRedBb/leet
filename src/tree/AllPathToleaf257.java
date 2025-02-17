package tree;

import java.util.ArrayList;
import java.util.List;
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
}
