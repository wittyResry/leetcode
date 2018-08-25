import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/08/25
 */
public class SymmetricTreeTest {

    @Test
    public void isSymmetric01() {
        SymmetricTree test = new SymmetricTree();
        Integer[] val = new Integer[] { -1, 1, 2, 2, 3, 4, 4, 3 };
        SymmetricTree.TreeNode r = new SymmetricTree.TreeNode(val[1]);
        build(val, 1, r);
        Assert.assertEquals("", true, test.isSymmetric(r));
    }

    @Test
    public void isSymmetric02() {
        SymmetricTree test = new SymmetricTree();
        Integer[] val = new Integer[] { 1, 2, 2, null, 3, null, 3 };
        SymmetricTree.TreeNode r = new SymmetricTree.TreeNode(val[1]);
        build(val, 1, r);
        Assert.assertEquals("", false, test.isSymmetric(r));
    }

    private void build(Integer[] val, int idx, SymmetricTree.TreeNode cur) {
        if (val[idx] == null) {
            return;
        }
        if (2 * idx < val.length && val[2 * idx] != null) {
            cur.left = new SymmetricTree.TreeNode(val[2 * idx]);
            build(val, 2 * idx, cur.left);
        }
        if (2 * idx + 1 < val.length && val[2 * idx + 1] != null) {
            cur.right = new SymmetricTree.TreeNode(val[2 * idx + 1]);
            build(val, 2 * idx + 1, cur.right);
        }
    }
}