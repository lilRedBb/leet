package tree;

public class lowerstCommentAN236 {

    //先直接dfs到最下，往上返回，
    //当一个节点的左，右返回值都不是null，就说明它就是距离pq最近的公共
    //然后最后一个三目，就是公共节点以上的那些节点应该如何把公共节点原原本本的返回去，他们返回的是left或者right的return值，不再是自身的root
    //这个是后序遍历，在回溯的过程中产生逻a
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
