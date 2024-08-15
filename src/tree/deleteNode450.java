package tree;

public class deleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            TreeNode minNode = findMin(root.right);
            root.value = minNode.value;
            root.right = deleteNode(root.right, minNode.value);
            //主node换成min以后，min还存在，跟主造成的重复
            //findmin方法就是把node下方最小的值找出来代替自己
            //把min的值作为参数，recurse，
            //这样以right为跟节点的这棵树，会被定为到min值锁在的地方，如果min值那个node下面还有node，
            // 那么min就被换掉，如果没有，那么min node就变成了null
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
