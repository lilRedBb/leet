package tree.battleGroundTree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class zhongshu501 {

    public Integer prev=null;
    public int max = 0;
    public int count =1;

    List<Integer> modes = new ArrayList<>();

    public void findMost(TreeNode root){
        if (root==null){return;}

        findMost(root.left);

        if (prev!=null){
            if (root.value==prev){
                count++;
            }else {
                count =1;
            }
        }

        if (count>max){
            max = count;
            modes.clear();
            modes.add(root.value);
        } else if (count==max) {
            modes.add(root.value);
        }

        prev = root.value;

        findMost(root.right);

    }


    public int[] find(TreeNode root) {
        findMost(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

}
