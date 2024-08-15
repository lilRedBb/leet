package tree.battleGroundTree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class scratch1 {
    public List<String> allPath(TreeNode root){
        List<String> listPath = new ArrayList<>();
        if (root!=null){findPath(root, "", listPath);}
        return listPath;
    }

    private void findPath(TreeNode root, String path, List<String> listPath){
        path += root.value;
        if (root.right!=null){findPath(root.right, path+"->", listPath);}
        else if (root.left!=null) {
            findPath(root.left, path+"->", listPath);
        }
        else{
            listPath.add(path);
        }
    }
}
