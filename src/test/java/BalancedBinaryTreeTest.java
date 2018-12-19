import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/12/19
 */
public class BalancedBinaryTreeTest {

    @Test
    public void isBalanced01() {
        BalancedBinaryTree test = new BalancedBinaryTree();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BalancedBinaryTree.TreeNode root = new BalancedBinaryTree.TreeNode(val[1]);
        build(val,1, root);
        Assert.assertEquals(true, test.isBalanced(root));
    }

    private void build(Integer[] val, int idx, BalancedBinaryTree.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BalancedBinaryTree.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BalancedBinaryTree.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}