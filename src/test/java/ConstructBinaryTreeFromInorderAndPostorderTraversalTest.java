import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/09/09
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @Test
    public void buildTree() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal test = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode root = test.buildTree(inorder,
            postorder);
        Assert.assertEquals(3, root.val);
        Assert.assertEquals(9, root.left.val);
        Assert.assertEquals(20, root.right.val);
        Assert.assertEquals(15, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
    }
}