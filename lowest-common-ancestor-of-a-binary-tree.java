/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean getPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == p) {
            return true;
        }
        if (root.left != null) {
            path.add(root.left);
            if (getPath(root.left, p, path)) return true;
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right);
            if (getPath(root.right, p, path)) return true;
            path.remove(path.size() - 1);
        }
        return false;
    } 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        List<TreeNode> pathP = new ArrayList<TreeNode>();
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        pathP.add(root);
        pathQ.add(root);
        if(!getPath(root, p, pathP)) return null;
        if(!getPath(root, q, pathQ)) return null;
        TreeNode lca = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); ++i) {
            if (pathP.get(i).equals(pathQ.get(i))) lca = pathP.get(i);
        }
        return lca;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;//p是q的儿子或者q是p的儿子会走到这个分支。
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root; // 返回这个节点，两个p和q分别是它的左边和右边儿子。
        return left != null ? left : (right != null ? right : (null));
        /*返回不是null那边的结果，否则结果覆盖了。
        1. 返回的结果两边都为null，则表示root分支下没有解。
        2. 返回的结果有一个非空，则这个节点一定有正确地解。
        */
    }
}