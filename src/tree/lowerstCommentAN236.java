package tree;

public class lowerstCommentAN236 {

    //先直接dfs到最下，往上返回，
    //当一个节点的左，右返回值都不是null，就说明它就是距离pq最近的公共
    //然后最后一个三目，就是公共节点以上的那些节点应该如何把公共节点原原本本的返回去，他们返回的是left或者right的return值，不再是自身的root
    //这个是后序遍历，在回溯的过程中产生逻a
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //到底了就回bull， 找到任何一个就往上return
        if (root == null || root == p || root == q) {
            return root;
        }

        //将上面的逻辑用于左，右树  （如果q在p下面，没到q就返回了p怎么办） 如果这样p就是pq的LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //左右都不是null的root才是lca
        if (left != null && right != null) {
            return root;
        }

        //这个在lca之外的层调用，可以返回lca，因为lca已经找到，另一边一定是null了
        return left != null ? left : right;
    }
}
