/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(-1);
        n1.next = headA;
        n2.next = headB;
        int len1 = 0, len2 = 0;
        for (ListNode n = n1; n.next != null; n = n.next) ++len1;
        for (ListNode n = n2; n.next != null; n = n.next) ++len2;
        while (len1 > len2) {
            n1 = n1.next;
            --len1;
        }
        while (len2 > len1) {
            n2 = n2.next;
            --len2;
        }
        if (n1.next == null || n2.next == null) {
            return null;
        }
        while (n1.next != null && n2.next != null) {
            if (n1.next == n2.next) return n1.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }
}