package tree;

public class loweestCOMMNANbfs235 {

    //当找到了一个值，他就存在在pq中间的时候，那么它一定是唯一解，因为如果存在该值，说明p在它左边，q在它右边， 从这里已经出现了分叉，
    //再往下已经不会再存在两者的公共节点了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.value < root.value && q.value < root.value) {
                root = root.left;
            } else if (p.value > root.value && q.value > root.value) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }




    public TreeNode lowestCommonAncestorRECUR(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestorRECUR(root.left, p, q);
        } else if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestorRECUR(root.right, p, q);
        } else {
            return root;
        }
    }
}
