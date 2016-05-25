/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode r = new ListNode(-1);
        r.next = null;
        ListNode ins = h.next;
        while (ins != null) {
            ListNode tmp = ins.next;//由于ins的next指针有改变，需要暂存ins.next
            ListNode t = r;
            while (t.next != null && t.next.val <= ins.val) {
                t = t.next;
            }
            ins.next = t.next;
            t.next = ins;
            
            ins = tmp;
        }
        return r.next;
    }
}