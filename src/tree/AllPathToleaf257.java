package tree;

import java.util.ArrayList;
import java.util.List;
//返回一棵树上的所有path到一个列表里
public class AllPathToleaf257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) findPaths(root, "", paths);
        return paths;
    }

    private void findPaths(TreeNode node, String path, List<String> paths) {
        path += node.value;
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            if (node.left != null) findPaths(node.left, path + "->", paths);
            if (node.right != null) findPaths(node.right, path + "->", paths);
        }
    }
}
