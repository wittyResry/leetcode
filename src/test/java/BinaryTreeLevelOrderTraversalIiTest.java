import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/30
 */
public class BinaryTreeLevelOrderTraversalIiTest {

    @Test
    public void levelOrderBottom() {

        BinaryTreeLevelOrderTraversalIi test = new BinaryTreeLevelOrderTraversalIi();
        Integer[] val = new Integer[] { -1, 3, 9, 20, null, null, 15, 7 };
        BinaryTreeLevelOrderTraversalIi.TreeNode r = new BinaryTreeLevelOrderTraversalIi.TreeNode(
            val[1]);
        build(val, 1, r);
        Assert.assertEquals("", "[[15, 7], [9, 20], [3]]", test.levelOrderBottom(r).toString());
    }

    private void build(Integer[] val, int idx, BinaryTreeLevelOrderTraversalIi.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new BinaryTreeLevelOrderTraversalIi.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new BinaryTreeLevelOrderTraversalIi.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}