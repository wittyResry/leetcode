/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
        TreeNode tr1 = root.left;
        TreeNode tr2 = root.right;
        root.left = tr2;
        root.right = tr1;
        return root;
    }

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
