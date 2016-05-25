/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = new ListNode(-1);
        h1.next = l1;
        ListNode h2 = new ListNode(-1);
        h2.next = l2;
        int len1 = 0;
        for (ListNode t = h1; t.next != null; t = t.next) len1++;
        int len2 = 0;
        for (ListNode t = h2; t.next != null; t = t.next) len2++;
        if (len2 > len1) {
            h1.next = l2;
            h2.next = l1;
        }
        ListNode res = new ListNode(-1);
        res.next = h1.next;
        int token = 0;
        for (; h2.next != null;) {
            ListNode node1 = h1.next;
            ListNode node2 = h2.next;
            int cur = node1.val + node2.val + token;
            node1.val = cur % 10;
            token = cur / 10;
            h1 = h1.next;
            h2 = h2.next;
        }
        while (token != 0) {
            if (h1.next == null) {
                h1.next = new ListNode(token%10);
                token = token / 10;
            } else {
                ListNode node1 = h1.next;
                int cur = node1.val + token;
                node1.val = cur % 10;
                token = cur / 10;
                h1 = h1.next;
            }
        }
        return res.next;
    }
}