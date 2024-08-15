package tree;

import java.util.ArrayList;
import java.util.List;

public class ModeNumberInBST501 {
    //找到树里面的众数
    private Integer prev = null;
    private int count = 1;
    private int max = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null) {
            if (node.value == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            modes.clear();
            modes.add(node.value);
        } else if (count == max) {
            modes.add(node.value);
        }

        prev = node.value;
        inOrder(node.right);
    }
}
