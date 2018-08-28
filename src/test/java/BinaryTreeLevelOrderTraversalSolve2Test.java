import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/08/28
 */
public class BinaryTreeLevelOrderTraversalSolve2Test {

    @Test
    public void levelOrder() {

        BinaryTreeLevelOrderTraversalSolve2 test = new BinaryTreeLevelOrderTraversalSolve2();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BinaryTreeLevelOrderTraversalSolve2.TreeNode r = new BinaryTreeLevelOrderTraversalSolve2.TreeNode(
                val[1]);
        build(val, 1, r);
        Assert.assertEquals("", "[[3], [9, 20], [15, 7]]", test.levelOrder(r).toString());
    }


    private void build(Integer[] val, int idx, BinaryTreeLevelOrderTraversalSolve2.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BinaryTreeLevelOrderTraversalSolve2.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BinaryTreeLevelOrderTraversalSolve2.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}