import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/08/28
 */
public class BinaryTreeLevelOrderTraversalSolve3Test {

    @Test
    public void levelOrder() {

        BinaryTreeLevelOrderTraversalSolve3 test = new BinaryTreeLevelOrderTraversalSolve3();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BinaryTreeLevelOrderTraversalSolve3.TreeNode r = new BinaryTreeLevelOrderTraversalSolve3.TreeNode(
            val[1]);
        build(val, 1, r);
        Assert.assertEquals("", "[[3], [9, 20], [15, 7]]", test.levelOrder(r).toString());
    }

    private void build(Integer[] val, int idx, BinaryTreeLevelOrderTraversalSolve3.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BinaryTreeLevelOrderTraversalSolve3.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BinaryTreeLevelOrderTraversalSolve3.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}