import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2019/02/01
 */
public class FlattenBinaryTreeToLinkedListTest {
    @Test
    public void flatten() throws Exception {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        Integer[] val = new Integer[] {-1, 1, 2, 5, 3, 4, null, 6};
        FlattenBinaryTreeToLinkedList.TreeNode r = new FlattenBinaryTreeToLinkedList.TreeNode(
                val[1]);
        build(val, 1, r);
        test.flatten(r);
        StringBuilder res = new StringBuilder();
        res.append(r.val);
        while(r.right != null) {
            res.append(",").append(r.right.val);
            Assert.assertNull(r.left);
            r = r.right;
        }
        Assert.assertEquals("1,2,3,4,5,6", res.toString());
    }

    private void build(Integer[] val, int idx, FlattenBinaryTreeToLinkedList.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new FlattenBinaryTreeToLinkedList.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new FlattenBinaryTreeToLinkedList.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}