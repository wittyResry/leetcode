import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/29
 */
public class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void zigzagLevelOrder() {
        BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BinaryTreeZigzagLevelOrderTraversal.TreeNode r = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(
            val[1]);
        build(val, 1, r);
        Assert.assertEquals("", "[[3], [20, 9], [15, 7]]", test.zigzagLevelOrder(r).toString());
    }

    private void build(Integer[] val, int idx, BinaryTreeZigzagLevelOrderTraversal.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BinaryTreeZigzagLevelOrderTraversal.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}