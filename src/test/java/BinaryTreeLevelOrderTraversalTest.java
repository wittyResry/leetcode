import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/26
 */
public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void levelOrder() {

        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BinaryTreeLevelOrderTraversal.TreeNode r = new BinaryTreeLevelOrderTraversal.TreeNode(
            val[1]);
        build(val, 1, r);
        Assert.assertEquals("", true, test.levelOrder(r));
    }

    private void build(Integer[] val, int idx, BinaryTreeLevelOrderTraversal.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BinaryTreeLevelOrderTraversal.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BinaryTreeLevelOrderTraversal.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}