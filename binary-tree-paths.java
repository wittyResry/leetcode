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
    private void dfs(TreeNode tree, int deep, int[] a, List<String> res) {
        if (tree == null) return;
        a[deep] = tree.val;
        if (tree.left == null && tree.right == null) {
            a[deep + 1] = -1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < deep + 1; ++i) {
                if (i == deep) {
                    sb.append(a[i]);
                } else {
                    sb.append(a[i]).append("->");
                }
            }
            res.add(sb.toString());
        }
        if (tree.left != null) dfs(tree.left, deep+1, a, res);
        if (tree.right != null) dfs(tree.right, deep+1, a, res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        dfs(root, 0, new int[100], res);
        return res;
    }
}