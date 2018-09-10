import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/09/10
 */
public class ConvertSortedListToBinarySearchTreeTest {

    @Test
    public void sortedListToBST() {
        ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
        ConvertSortedListToBinarySearchTree.ListNode head = new ConvertSortedListToBinarySearchTree.ListNode(-10);
        head.next = new ConvertSortedListToBinarySearchTree.ListNode(-3);
        head.next.next = new ConvertSortedListToBinarySearchTree.ListNode(0);
        head.next.next.next = new ConvertSortedListToBinarySearchTree.ListNode(5);
        head.next.next.next.next = new ConvertSortedListToBinarySearchTree.ListNode(9);
        head.next.next.next.next.next = null;
        ConvertSortedListToBinarySearchTree.TreeNode res = test.sortedListToBST(head);
        Assert.assertEquals("", 0, res.val);
    }
}